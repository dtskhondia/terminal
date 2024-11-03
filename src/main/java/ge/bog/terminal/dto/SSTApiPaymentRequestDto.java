package ge.bog.terminal.dto;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record SSTApiPaymentRequestDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    BigDecimal amount,
    String status,
    LocalDateTime createTime
){}
