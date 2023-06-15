package ucr.gasIn.transactionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.domain.Transaction;
import ucr.gasIn.transactionservice.service.TransactionService;

import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "/api/Transaction")
public class TransactionController {
    @Autowired
    private TransactionService service;
    @GetMapping("/get")
    public List<Transaction> list() {
        return service.listAll();
    }

    @GetMapping("/getId/{id}")
    public ResponseEntity<Transaction> get(@PathVariable Integer id) {
        try {
            Transaction transaction = service.get(id);
            return new ResponseEntity<Transaction>(transaction, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/insert")
    public void add(@RequestBody Transaction transaction) {service.save(transaction);
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") int id,
                       @RequestBody Transaction transaction) {
        Transaction entity = transaction;
        entity.setId(id);
        service.update(entity);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
