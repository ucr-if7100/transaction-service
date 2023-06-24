package ucr.gasIn.transactionservice.exceptions;


import java.util.UUID;

public record ErrorResponse(
        String message,
        int code
) {

}