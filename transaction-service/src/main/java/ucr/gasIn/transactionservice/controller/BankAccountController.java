package ucr.gasIn.transactionservice.controller;

import liquibase.resource.ResourceAccessor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ucr.gasIn.transactionservice.converter.BankAccountRestConverter;
import ucr.gasIn.transactionservice.dto.BankAccountDTO;
import ucr.gasIn.transactionservice.service.BankAccountService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/bank_account")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    BankAccountRestConverter converter;

    @PostMapping(path = "/save")
    public boolean saveBankAccount
            (@RequestBody BankAccountDTO bankAccount) {
        return bankAccountService.save(converter.postRequest(bankAccount));
    }

    @GetMapping(path = "/accountNumber/{accountNumber}")
    public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable int accountNumber){
        BankAccountDTO bankAccountDTO = converter.getAccountNumberResponse(bankAccountService.find_by_id(accountNumber));
        if(bankAccountDTO != null)
            return ResponseEntity.ok(bankAccountDTO);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<BankAccountDTO>> getUserBankAccounts(@PathVariable int userId){
        List<BankAccountDTO> bankAccountsDTO = converter.getUserResponse(bankAccountService.find_by_user_id(userId));
        if(!bankAccountsDTO.isEmpty())
            return ResponseEntity.ok(bankAccountsDTO);
        else
            return ResponseEntity.notFound().build();
    }
    @PostMapping(path = "/update")
    public void updateBankAccount
            (@RequestBody BankAccountDTO bankAccount) {
         bankAccountService.update(converter.postRequest(bankAccount));
    }
}
