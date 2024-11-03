package ge.bog.terminal.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record SSTApiPaymentResponseDto(
    SSTApiTerminalDto terminal,
    SSTApiProviderDto provider,
    String abonentCode,
    BigDecimal amount,
    String status,
    LocalDateTime createTime
){}
