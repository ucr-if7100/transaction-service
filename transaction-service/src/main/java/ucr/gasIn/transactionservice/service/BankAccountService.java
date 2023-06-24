package ucr.gasIn.transactionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.repository.BankAccountRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<BankAccount> find_by_id(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid);
    }

    public Optional<List<BankAccount>> find_by_user_id(String userId) {
        UUID uuid = UUID.fromString(userId);
        return repository.findAllByUserId(uuid);
    }

    public void update(BankAccount entity) {
        BankAccount entityToUpdate = repository.findById(entity.getId()).get();
        if(entityToUpdate != null) {
            repository.save(entity);
        }
    }
    public boolean delete(String id) {
        UUID uuid = UUID.fromString(id);
        Optional<BankAccount> bankAccount = repository.findById(uuid);
        if(bankAccount.isPresent()){
            if(repository.deleteBankAccountById(uuid,false) > 0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
}
