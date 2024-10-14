package ge.bog.terminal.dto;

import lombok.Builder;

@Builder
public record DebtDtoExternal(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long amount
){}

