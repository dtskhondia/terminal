package ge.bog.terminal.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Payment {
    private Long terminalId;
    private Long providerId;
    private String abonentCode;
    private BigDecimal paymentAmount;
    private String status;
    private LocalDateTime createTime;
}
