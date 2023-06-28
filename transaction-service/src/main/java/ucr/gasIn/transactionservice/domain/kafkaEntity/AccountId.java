package ucr.gasIn.transactionservice.domain.kafkaEntity;

public class AccountId {
    private String id;
    private String phoneNumber;
    private String last4;
    private String actNumber;
    private String iban;

    public AccountId(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLast4() {
        return last4;
    }

    public void setLast4(String last4) {
        this.last4 = last4;
    }

    public String getActNumber() {
        return actNumber;
    }

    public void setActNumber(String actNumber) {
        this.actNumber = actNumber;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "AccountId{" +
                "id='" + id + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", last4='" + last4 + '\'' +
                ", actNumber='" + actNumber + '\'' +
                ", iban='" + iban + '\'' +
                '}';
    }
}
