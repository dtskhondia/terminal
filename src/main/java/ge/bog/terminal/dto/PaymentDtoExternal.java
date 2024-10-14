package ge.bog.terminal.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PaymentDtoExternal(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long amount,
    String status,
    LocalDateTime createTime
){}
