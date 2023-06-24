package ucr.gasIn.transactionservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionResponseHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                ex.getCode()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<ErrorResponse> handleInputException(InvalidInputException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getField(),
                ErrorCodes.INVALID_INPUT
        );
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(BDTransactionErrorException.class)
    public ResponseEntity<ErrorResponse> handleBDErrorException(BDTransactionErrorException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                ErrorCodes.UNKNOWN_ERROR
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleAccountNotFoundException(AccountNotFoundException ex) {

        ErrorResponse response = new ErrorResponse(
                ex.getMessage(),
                ErrorCodes.NOT_FOUND
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
