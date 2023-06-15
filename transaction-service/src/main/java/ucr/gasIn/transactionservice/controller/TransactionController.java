package ucr.gasIn.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.domain.Transaction;
import ucr.gasIn.transactionservice.dto.TransactionDTO;
import ucr.gasIn.transactionservice.service.TransactionService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/Transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @GetMapping("/get")
    public List<TransactionDTO> list() {
        return service.listAll();
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<TransactionDTO> get(@PathVariable("id") String id) {
        try {
            UUID idTransaction = UUID.fromString(id);
            TransactionDTO transaction = service.get(idTransaction);
            return new ResponseEntity<TransactionDTO>(transaction, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<TransactionDTO>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/insert")
    public void add(@RequestBody TransactionDTO transactionDTO) {service.save(transactionDTO);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") String id,
                       @RequestBody TransactionDTO transactionDTO) {
        TransactionDTO entity = transactionDTO;
        UUID idTransaction = UUID.fromString(id);
        entity.setId(idTransaction);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id) {
        UUID idTransaction = UUID.fromString(id);
        service.delete(idTransaction);
    }
}
