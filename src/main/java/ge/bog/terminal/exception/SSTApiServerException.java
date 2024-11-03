package ge.bog.terminal.exception;

import lombok.Getter;

@Getter
public class SSTApiServerException extends RuntimeException{
    public SSTApiServerException(String message){
        super(message);
    }
}
