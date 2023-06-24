package ucr.gasIn.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.converter.BankAccountRestConverter;
import ucr.gasIn.transactionservice.dto.BankAccountDTO;
import ucr.gasIn.transactionservice.dto.UpdateBankAccountDTO;
import ucr.gasIn.transactionservice.handler.DeleteBankAccountHandler;
import ucr.gasIn.transactionservice.handler.UpdateBankAccountHandler;
import ucr.gasIn.transactionservice.service.BankAccountService;
import java.util.List;


@RestController
@RequestMapping("/bank_account")
@CrossOrigin(origins = "http://localhost:4200/*")
public class BankAccountController {
    @Autowired
    BankAccountService bankAccountService;
    @Autowired
    BankAccountRestConverter converter;

    @Autowired
    UpdateBankAccountHandler updateHandler;

    @Autowired
    DeleteBankAccountHandler deleteHandler;

    @PostMapping(path = "/save")
    public boolean saveBankAccount
            (@RequestBody BankAccountDTO bankAccount) {
        return bankAccountService.save(converter.postRequest(bankAccount));
    }

    @GetMapping(path = "/accountNumber/{id}")
    public ResponseEntity<BankAccountDTO> getBankAccount(@PathVariable String id){
        BankAccountDTO bankAccountDTO = converter.getAccountNumberResponse(bankAccountService.find_by_id(id));
        if(bankAccountDTO != null)
            return ResponseEntity.ok(bankAccountDTO);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<List<BankAccountDTO>> getUserBankAccounts(@PathVariable String userId){
        List<BankAccountDTO> bankAccountsDTO = converter.getUserResponse(bankAccountService.find_by_user_id(userId));
        if(!bankAccountsDTO.isEmpty())
            return ResponseEntity.ok(bankAccountsDTO);
        else
            return ResponseEntity.notFound().build();
    }
    @DeleteMapping (path = "/delete/{id}")
    public ResponseEntity<Void> deleteBankAccount (@PathVariable String id) {
        deleteHandler.delete(new DeleteBankAccountHandler.Command(id));
        return ResponseEntity.status(HttpStatus.OK).build();

    }
    @PutMapping (path = "/update/{id}")
    public ResponseEntity<Void> updateBankAccount (@PathVariable String id, @RequestBody UpdateBankAccountDTO bankAccountDTO ) {
        updateHandler.update(new UpdateBankAccountHandler.Command(id,
                bankAccountDTO.getAccountName(),
                bankAccountDTO.getPhoneNumber(),
                bankAccountDTO.getCard()));
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
