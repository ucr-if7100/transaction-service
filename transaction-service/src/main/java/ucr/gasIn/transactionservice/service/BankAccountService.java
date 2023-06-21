package ucr.gasIn.transactionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.repository.BankAccountRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BankAccountService {

    @Autowired
    private BankAccountRepository repository;

    public List<BankAccount> listAll() {
        return repository.findAll();
    }

    public boolean save(BankAccount bankAccount) {
        return repository.save(bankAccount) != null;
    }

    public Optional<BankAccount> find_by_id(int accountNumber) {
        return repository.findById(accountNumber);
    }

    public Optional<List<BankAccount>> find_by_user_id(int userId) {
        return repository.findAllByUserId(userId);
    }

    public void update(BankAccount entity) {
        BankAccount entityToUpdate = repository.findById(entity.getAccountNumber()).get();
        if(entityToUpdate != null) {
            repository.save(entity);
        }
    }
    public void delete(int id) {repository.deleteById(id);
    }
}
