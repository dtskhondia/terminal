package ge.bog.terminal.dto;

import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record PaymentDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long paymentAmount,
    String status,
    LocalDateTime createTime
){}
