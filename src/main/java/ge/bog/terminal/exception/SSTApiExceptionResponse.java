package ge.bog.terminal.exception;

import lombok.Builder;

@Builder
public record SSTApiExceptionResponse(
    int statusCode,
    String errorCode,
    String errorMessage
){}
