package ucr.gasIn.transactionservice.converter;

import org.springframework.stereotype.Service;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.dto.BankAccountDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountRestConverter {

    public BankAccount postRequest(BankAccountDTO bankAccountDTO){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(bankAccountDTO.getAccountNumber());
        bankAccount.setAccountName(bankAccountDTO.getAccountName());
        bankAccount.setBankAccountType(bankAccountDTO.getBankAccountType());
        bankAccount.setBankName(bankAccountDTO.getBankName());
        bankAccount.setCard(bankAccountDTO.getCard());
        bankAccount.setIban(bankAccountDTO.getIban());
        bankAccount.setCurrentBalance(bankAccountDTO.getCurrentBalance());
        bankAccount.setPhoneNumber(bankAccountDTO.getPhoneNumber());
        bankAccount.setId_user(bankAccountDTO.getId_user());

        return bankAccount;

    }

    public BankAccountDTO getAccountNumberResponse(BankAccount bankAccount){
        return new BankAccountDTO.builder(bankAccount).getAccountNumberResponse().build();

    }

    public List<BankAccountDTO> getUserResponse(List<BankAccount> bankAccounts){
        List<BankAccountDTO> bankAccountsDTO = new ArrayList<BankAccountDTO>();
        for (BankAccount bankAccount:bankAccounts) {
            BankAccountDTO bankAccountDTO = new BankAccountDTO.builder(bankAccount).getUserIdResponse().build();
            bankAccountsDTO.add(bankAccountDTO);
        }
        return bankAccountsDTO;
    }

}
