package ucr.gasIn.transactionservice.converter;

import org.springframework.stereotype.Service;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.dto.BankAccountDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BankAccountRestConverter {

    public BankAccount postRequest(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountName(bankAccountDTO.getAccountName());
        bankAccount.setBankAccountType(bankAccountDTO.getBankAccountType());
        bankAccount.setBankName(bankAccountDTO.getBankName());
        bankAccount.setCard(bankAccountDTO.getCard());
        bankAccount.setIban(bankAccountDTO.getIban());
        bankAccount.setCurrentBalance(bankAccountDTO.getCurrentBalance());
        bankAccount.setPhoneNumber(bankAccountDTO.getPhoneNumber());
        bankAccount.setId_user(bankAccountDTO.getId_user());
        bankAccount.setActive(true);

        return bankAccount;

    }

    public BankAccountDTO getAccountNumberResponse(Optional<BankAccount> bankAccount){
        if (bankAccount.isPresent())
            return new BankAccountDTO.builder(bankAccount.get()).getAccountNumberResponse().build();
        else
            return null;

    }

    public List<BankAccountDTO> getUserResponse(Optional<List<BankAccount>> bankAccounts){
        List<BankAccountDTO> bankAccountsDTO = new ArrayList<BankAccountDTO>();
        if(bankAccounts.isPresent()) {
            for (BankAccount bankAccount : bankAccounts.get()) {
                BankAccountDTO bankAccountDTO = new BankAccountDTO.builder(bankAccount).getUserIdResponse().build();
                bankAccountsDTO.add(bankAccountDTO);
            }
            return bankAccountsDTO;
        }else{
            return bankAccountsDTO;
        }
    }

    public boolean validateUUID(String id){
        try {
            UUID uuid = UUID.fromString(id);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }

    }

}
