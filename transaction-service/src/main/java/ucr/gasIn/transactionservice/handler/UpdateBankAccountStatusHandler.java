package ucr.gasIn.transactionservice.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.exceptions.AccountNotFoundException;
import ucr.gasIn.transactionservice.exceptions.BDTransactionErrorException;
import ucr.gasIn.transactionservice.exceptions.BusinessException;
import ucr.gasIn.transactionservice.repository.BankAccountRepository;

import java.util.UUID;

@Component
@Transactional
public class UpdateBankAccountStatusHandler {
    @Autowired
    private BankAccountRepository repository;

    public record Command(String id, boolean bool) {
    }

    public void update(Command command) {
        UUID uuid=validateUUID(command.id());
        validateExistingBankAccount(uuid);
        validateDelete(uuid,command.bool());
    }

    private UUID validateUUID(String id) {
        try {
            UUID uuid = UUID.fromString(id);
            return uuid;
        } catch (IllegalArgumentException e) {
            throw new BusinessException("Invalid UUID");
        }

    }

    private void validateExistingBankAccount(UUID id){
        if(!repository.findById(id).isPresent()){
            throw new AccountNotFoundException("Account doesnt exists");
        }
    }

    private void validateDelete(UUID uuid, boolean bool){
        if(repository.deleteBankAccountById(uuid, bool) == 0){
            throw new BDTransactionErrorException("Error deleting account");
        }
    }
}
