package ge.bog.terminal.dto;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record SSTApiFeeResponseDto(
    SSTApiTerminalDto terminal,
    SSTApiProviderDto provider,
    String abonentCode,
    BigDecimal amount
){}

