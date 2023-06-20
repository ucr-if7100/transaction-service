package ucr.gasIn.transactionservice.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccount {
    @Id
    @Column(name = "Account_number", unique = true, nullable = false)
    private int accountNumber;

    @Column(name = "Account_Name", unique = false, length = 100, nullable = false)
    private String accountName;

    @Column(name = "Bank_name", unique = false, length = 100, nullable = false)
    private String bankName;

    @Enumerated(EnumType.STRING)
    @Column(name = "Bank_account_type")
    private BankAccountType bankAccountType;

    @Column(name = "Current_balance", unique = false, nullable = false)
    private Float currentBalance;

    @Column(name = "Card", unique = false, length = 4, nullable = false)
    private String card;

    @Column(name = "IBAN", unique = false, length = 100, nullable = false)
    private String iban;
    @Column(name = "Phone_number", unique = false, length = 8, nullable = false)
    private String phoneNumber;

    @Column(name = "id_user")
    private int id_user;

    public BankAccount() {
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
