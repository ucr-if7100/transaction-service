package ucr.gasIn.transactionservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ucr.gasIn.transactionservice.domain.BankAccount;
import ucr.gasIn.transactionservice.domain.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {
    @Query("SELECT b FROM BankAccount b WHERE b.id_user = :userId")
    Optional<List<BankAccount>> findAllByUserId(@Param("userId") UUID userId);
    @Modifying
    @Query("UPDATE BankAccount b SET b.active = :bool WHERE b.id = :id")
    int deleteBankAccountById(@Param("id") UUID id, boolean bool);
    @Modifying
    @Query("UPDATE BankAccount b SET b.accountName = :accountName, b.phoneNumber = :phone_number, b.card = :card  WHERE b.id = :id")
    int updateCreditDebitAccount(UUID id, String accountName, String phone_number, String card);
    @Modifying
    @Query("UPDATE BankAccount b SET b.accountName = :accountName WHERE b.id = :id")
    int updateCashBankAccount(UUID id, String accountName);
    @Query("SELECT b FROM BankAccount b WHERE b.id = :Id")
    Optional<BankAccount> findById(@Param("Id") UUID Id);

}
