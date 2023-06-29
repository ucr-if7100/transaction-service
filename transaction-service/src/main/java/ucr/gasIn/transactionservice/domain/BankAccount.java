package ucr.gasIn.transactionservice.domain;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "Id", columnDefinition = "BINARY(16)")
    private UUID id;
    @Column(name = "Account_Name", unique = false, length = 100, nullable = false)
    private String accountName;

    @Column(name = "Bank_name", unique = false, length = 100, nullable = true)
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Bank_account_type")
    private BankAccountType bankAccountType;

    @Column(name = "Current_balance", unique = false, nullable = false)
    private Float currentBalance;

    @Column(name = "Card", unique = false, length = 4, nullable = true)
    private String card;

    @Column(name = "IBAN", unique = false, length = 100, nullable = true)
    private String iban;
    @Column(name = "Phone_number", unique = false, length = 8, nullable = true)
    private String phoneNumber;

    @Column(name = "Id_user", columnDefinition = "BINARY(16)")
    private UUID id_user;

    @Column(name = "Active", columnDefinition = "BIT")
    private Boolean active;

    public BankAccount() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public BankAccountType getBankAccountType() {
        return bankAccountType;
    }

    public void setBankAccountType(BankAccountType bankAccountType) {
        this.bankAccountType = bankAccountType;
    }

    public Float getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Float currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
