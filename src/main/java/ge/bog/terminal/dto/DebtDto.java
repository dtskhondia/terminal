package ge.bog.terminal.dto;

import lombok.Builder;

@Builder
public record DebtDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long debtAmount
){}
