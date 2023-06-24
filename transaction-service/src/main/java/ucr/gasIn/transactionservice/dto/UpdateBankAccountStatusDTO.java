package ucr.gasIn.transactionservice.dto;

public class UpdateBankAccountStatusDTO {
    private boolean active;

    public UpdateBankAccountStatusDTO() {
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
