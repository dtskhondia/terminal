package ge.bog.terminal.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record SSTApiPaymentDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long amount,
    String status,
    LocalDateTime createTime
){}
