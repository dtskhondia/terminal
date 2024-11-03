package ge.bog.terminal.exception;

import lombok.Getter;

@Getter
public class SSTApiClientException extends RuntimeException{
    private final String errorCode;

    public SSTApiClientException(String message, String errorCode){
        super(message);
        this.errorCode = errorCode;
    }
}
