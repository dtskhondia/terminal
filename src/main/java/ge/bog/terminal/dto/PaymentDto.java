package ge.bog.terminal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record PaymentDto(
    @Schema(example = "1")
    Long terminalId,
    @Schema(example = "1")
    Long providerId,
    @Schema(example = "100000")
    String abonentCode,
    @Schema(example = "25")
    BigDecimal paymentAmount,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) String status,
    @JsonProperty(access = JsonProperty.Access.READ_ONLY) LocalDateTime createTime
){}
