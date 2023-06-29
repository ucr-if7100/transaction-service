package ucr.gasIn.transactionservice.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.exceptions.AccountNotFoundException;
import ucr.gasIn.transactionservice.exceptions.BDTransactionErrorException;
import ucr.gasIn.transactionservice.exceptions.BusinessException;
import ucr.gasIn.transactionservice.exceptions.InvalidInputException;
import ucr.gasIn.transactionservice.repository.BankAccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
@Transactional
public class GetBankAccountHandler {
    @Autowired
    private BankAccountRepository repository;

    public record Command(String id) {
    }

    public Optional<List<BankAccount>> get(Command command) {
        UUID uuid=validateUUID(command.id());
        if(uuid != null){
            validateExistingBankAccount(uuid);
            return GetBankAccount(uuid);
        }else{

            validateExistingBankAccount(uuid);

        }
        return null;
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
        if(!repository.findAllByUserId(id).isPresent()){
            throw new AccountNotFoundException("id doesnt exists");
        }
    }




    private Optional <List<BankAccount>> GetBankAccount(UUID uuid){

            return repository.findAllByUserId(uuid);

    }



}
