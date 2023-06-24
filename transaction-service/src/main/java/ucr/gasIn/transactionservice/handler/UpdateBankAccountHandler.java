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

import java.util.UUID;

@Component
@Transactional
public class UpdateBankAccountHandler {
    @Autowired
    private BankAccountRepository repository;

    public record Command(String id, String accountName , String phone_number, String card) {
    }

    public void update(Command command) {
        UUID uuid=validateUUID(command.id());
        if(command.phone_number() != null && command.card() != null){
            validateUpdateCreditDebitAccountsRequiredFields(command);
            validateExistingBankAccount(uuid);
            UpdateCreditDebitAccount(uuid,
                    command.accountName(),
                    command.phone_number(),
                    command.card());
        }else{
            validateUpdateCashAccountsRequiredFields(command);
            validateExistingBankAccount(uuid);
            UpdateCashAccount(uuid,command.accountName());
        }
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

    private void validateUpdateCreditDebitAccountsRequiredFields(Command command) {
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

    private void validateUpdateCashAccountsRequiredFields(Command command) {
        if (command.id() == null) {
            throw new InvalidInputException("id");
        }
        if (command.accountName() == null) {
            throw new InvalidInputException("accountName");
        }
    }

    private void UpdateCreditDebitAccount(UUID uuid, String accountName , String phone_number, String card){
        if(repository.updateCreditDebitAccount(uuid, accountName, phone_number, card) == 0){
            throw new BDTransactionErrorException("Error updating account");
        }
    }

    private void UpdateCashAccount(UUID uuid, String accountName){
        if(repository.updateCashBankAccount(uuid, accountName) == 0){
            throw new BDTransactionErrorException("Error updating account");
        }
    }

}
