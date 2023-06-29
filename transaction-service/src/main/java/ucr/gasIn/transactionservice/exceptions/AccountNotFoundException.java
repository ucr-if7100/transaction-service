package ucr.gasIn.transactionservice.exceptions;

public class AccountNotFoundException extends RuntimeException {
    private int code;

    public AccountNotFoundException(String message) {
        super(message);
        code = ErrorCodes.ERROR_NOT_IDENTIFIED;
    }

    public AccountNotFoundException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
