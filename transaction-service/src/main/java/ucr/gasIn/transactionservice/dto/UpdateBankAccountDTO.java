package ucr.gasIn.transactionservice.dto;

public class UpdateBankAccountDTO {
    private String accountName;
    private String phoneNumber;
    private String card;

    public UpdateBankAccountDTO() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
