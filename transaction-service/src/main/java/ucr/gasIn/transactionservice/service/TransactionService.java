package ucr.gasIn.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.Transaction;
import ucr.gasIn.transactionservice.dto.TransactionDTO;
import ucr.gasIn.transactionservice.repository.TransactionRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public List<TransactionDTO> listAll() {
        return repository.findAll().stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public void save(TransactionDTO transactionDTO) {
        Transaction transaction = convertDtoToEntity(transactionDTO);
        repository.save(transaction);
    }

    public TransactionDTO get(UUID idTransaction) {
        return repository.findById(idTransaction).map(this::convertEntityToDto).orElse(null);
    }

    public void update(TransactionDTO transactionDTO) {
        Transaction transaction = convertDtoToEntity(transactionDTO);
        Transaction entityToUpdate = repository.findById(transaction.getId()).get();
        if(entityToUpdate != null) {
            repository.save(transaction);
        }
    }
    public void delete(UUID id) {repository.deleteById(id);
    }

    private TransactionDTO convertEntityToDto(Transaction transaction){
        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setId(transaction.getId());
        transactionDTO.setIdAccount(transaction.getIdAccount());
        transactionDTO.setIdUser(transaction.getIdUser());
        transactionDTO.setDate(transaction.getDate());
        transactionDTO.setNumRefBank(transaction.getNumRefBank());
        transactionDTO.setType(transaction.getType());
        transactionDTO.setDescription(transaction.getDescription());
        transactionDTO.setIdCategory(transaction.getIdCategory());
        transactionDTO.setAmount(transaction.getAmount());
        return transactionDTO;
    }

    private Transaction convertDtoToEntity(TransactionDTO transactionDTO){
        Transaction transaction = new Transaction();
        transaction.setId(transactionDTO.getId());
        transaction.setIdUser(transactionDTO.getIdUser());
        transaction.setDate(transactionDTO.getDate());
        transaction.setNumRefBank(transactionDTO.getNumRefBank());
        transaction.setType(transactionDTO.getType());
        transaction.setDescription(transactionDTO.getDescription());
        transaction.setIdCategory(transactionDTO.getIdCategory());
        transaction.setAmount(transactionDTO.getAmount());
        transaction.setIdAccount(transactionDTO.getIdAccount());
        return transaction;
    }
}
