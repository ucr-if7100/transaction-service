package ucr.gasIn.transactionservice.domain.kafkaEntity;

import ucr.gasIn.transactionservice.domain.TransactionType;

import java.util.Date;

public class KafkaTransaction {

    private String id;
    private String email;
    private Date date;
    private float amount;
    private String reference;
    private String description;
    private String category;
    private String bank;
    private TransactionType transactionType;
    private AccountId accountId;

    public KafkaTransaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public AccountId getAccountId() {
        return accountId;
    }

    public void setAccountId(AccountId accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "KafkaTransaction{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", reference='" + reference + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", bank=" + bank + '\'' +
                ", transactionType=" + transactionType +
                ", accountId=" + accountId +
                '}';
    }
}
