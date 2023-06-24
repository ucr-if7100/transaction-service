package ucr.gasIn.transactionservice.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.exceptions.BDTransactionErrorException;
import ucr.gasIn.transactionservice.exceptions.BusinessException;
import ucr.gasIn.transactionservice.exceptions.InvalidInputException;
import ucr.gasIn.transactionservice.repository.BankAccountRepository;

import java.util.UUID;

@Component
public class DeleteBankAccountHandler {
    @Autowired
    private BankAccountRepository repository;

    public record Command(String id) {
    }

    public void delete(Command command) {
        UUID uuid=validateUUID(command.id());
        validateExistingBankAccount(uuid);
        validateDelete(uuid);
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
            throw new BusinessException("Account doesnt exists");
        }
    }

    private void validateDelete(UUID uuid){
        if(repository.deleteBankAccountById(uuid,false) == 0){
            throw new BDTransactionErrorException("Error deleting account");
        }
    }
}
