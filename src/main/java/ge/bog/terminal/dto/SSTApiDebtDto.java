package ge.bog.terminal.dto;

import lombok.Builder;

@Builder
public record SSTApiDebtDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long amount
){}

