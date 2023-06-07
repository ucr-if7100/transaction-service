package ucr.gasIn.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ucr.gasIn.transactionservice.domain.Category;
import ucr.gasIn.transactionservice.domain.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}