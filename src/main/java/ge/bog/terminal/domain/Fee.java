package ge.bog.terminal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class Fee {
    private Long terminalId;
    private Long providerId;
    private String abonentCode;
    private BigDecimal feeAmount;
}
