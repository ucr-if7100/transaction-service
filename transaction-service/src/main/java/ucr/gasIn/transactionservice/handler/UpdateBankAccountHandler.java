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
public class UpdateBankAccountHandler {
    @Autowired
    private BankAccountRepository repository;

    public record Command(String id, String accountName , String phone_number, String card) {
    }

    public void update(Command command) {
        UUID uuid=validateUUID(command.id());
        validateRequiredFields(command);
        validateExistingBankAccount(uuid);
        validateUpdate(uuid,
                command.accountName(),
                command.phone_number(),
                command.card());
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

    private void validateRequiredFields(Command command) {
        if (command.id() == null) {
            throw new InvalidInputException("id");
        }
        if (command.accountName() == null) {
            throw new InvalidInputException("accountName");
        }
        if (command.phone_number() == null) {
            throw new InvalidInputException("phone_number");
        }
        if (command.card() == null) {
            throw new InvalidInputException("card");
        }
    }

    private void validateUpdate(UUID uuid, String accountName , String phone_number, String card){
        if(repository.updateBankAccount(uuid, accountName, phone_number, card) == 0){
            throw new BDTransactionErrorException("Error updating account");
        }
    }

}
