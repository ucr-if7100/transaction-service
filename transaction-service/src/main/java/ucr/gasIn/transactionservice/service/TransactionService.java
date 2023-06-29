package ucr.gasIn.transactionservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ucr.gasIn.transactionservice.domain.Transaction;
import ucr.gasIn.transactionservice.domain.TransactionType;
import ucr.gasIn.transactionservice.dto.TransactionDTO;
import ucr.gasIn.transactionservice.repository.TransactionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        Transaction entityToUpdate = repository.findById(transaction.getId()).orElse(null);
        if (entityToUpdate != null) {
            repository.save(transaction);
        } else {
            System.out.println("No se encontro el usuario");
        }
    }
    public void delete(UUID id) {repository.deleteById(id);
    }


    public List<TransactionDTO> getIncomeByIdUser(UUID idUser) {
         List<TransactionDTO> allTransactions = listAll();
        List<TransactionDTO> filteredTransactions = new ArrayList<>();
        for (TransactionDTO transaction : allTransactions) {
            if (transaction.getIdUser().equals(idUser) && transaction.getType() == TransactionType.INCOME) {
                filteredTransactions.add(transaction);
            }
        }

        return filteredTransactions;
    }

    public List<TransactionDTO> getExpenseByIdUser(UUID idUser) {
        List<TransactionDTO> allTransactions = listAll();
        List<TransactionDTO> filteredTransactions = new ArrayList<>();
        for (TransactionDTO transaction : allTransactions) {
            if (transaction.getIdUser().equals(idUser) && transaction.getType() == TransactionType.EXPENSE) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
    }

    public List<TransactionDTO> getMyTransactionsByIdUser(UUID idUser) {
        List<TransactionDTO> allTransactions = listAll();
        List<TransactionDTO> filteredTransactions = new ArrayList<>();
        for (TransactionDTO transaction : allTransactions) {
            if (transaction.getIdUser().equals(idUser)) {
                filteredTransactions.add(transaction);
            }
        }
        return filteredTransactions;
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
