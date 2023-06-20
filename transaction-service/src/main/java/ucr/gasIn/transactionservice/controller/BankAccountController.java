package ucr.gasIn.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.converter.BankAccountRestConverter;
import ucr.gasIn.transactionservice.dto.BankAccountDTO;
import ucr.gasIn.transactionservice.service.BankAccountService;

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
    public BankAccountDTO getBankAccount(@PathVariable int accountNumber){
        return converter.getAccountNumberResponse(bankAccountService.find_by_id(accountNumber));
    }

    @GetMapping(path = "/user/{userId}")
    public List<BankAccountDTO> getUserBankAccounts(@PathVariable int userId){
        return converter.getUserResponse(bankAccountService.find_by_user_id(userId));
    }

}
