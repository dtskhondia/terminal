package ge.bog.terminal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {SSTApiClientException.class})
    public ResponseEntity<Object> handleSSTApiClientException(SSTApiClientException ex, WebRequest request){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .errorCode(ex.getErrorCode())
            .errorMessage(ex.getMessage())
            .build();
        return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {SSTApiServerException.class})
    public ResponseEntity<Object> handleSSTApiServerException(SSTApiServerException ex, WebRequest request){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
            .errorCode(SSTApiServerException.class.getSimpleName())
            .errorMessage(ex.getMessage())
            .build();
        return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_GATEWAY);
    }
}
