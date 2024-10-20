package ge.bog.terminal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record PaymentDto(
    Long terminalId,
    Long providerId,
    String abonentCode,
    Long paymentAmount,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) String status,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) LocalDateTime createTime
){}
