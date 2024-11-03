package ge.bog.terminal.exception;

import lombok.Builder;

@Builder
public record ExceptionResponse(
    String errorCode,
    String errorMessage
){}
