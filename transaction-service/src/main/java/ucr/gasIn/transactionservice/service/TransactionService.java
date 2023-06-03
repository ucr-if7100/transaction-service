package ucr.gasIn.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.Transaction;
import ucr.gasIn.transactionservice.repository.TransactionRepository;

import java.util.List;
@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public List<Transaction> listAll() {
        return repository.findAll();
    }

    public void save(Transaction transaction) {
        repository.save(transaction);
    }

    public Transaction get(int idTransaction) {
        return repository.findById(idTransaction).get();
    }

    public void update(Transaction transaction) {
        Transaction entityToUpdate = repository.findById(transaction.getId()).get();
        if(entityToUpdate != null) {
            repository.save(transaction);
        }
    }
    public void delete(int id) {repository.deleteById(id);
    }
}
