package ucr.gasIn.transactionservice.dto;

public class UpdateBankAccountStatusDTO {
    private boolean status;

    public UpdateBankAccountStatusDTO() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
