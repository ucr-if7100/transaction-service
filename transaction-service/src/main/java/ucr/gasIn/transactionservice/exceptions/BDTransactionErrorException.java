package ucr.gasIn.transactionservice.exceptions;

public class BDTransactionErrorException extends RuntimeException{
    private int code;

    public BDTransactionErrorException(String message) {
        super(message);
        code = ErrorCodes.ERROR_NOT_IDENTIFIED;
    }

    public BDTransactionErrorException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
