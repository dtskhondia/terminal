package ge.bog.terminal.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Payment {
    private Long terminalId;
    private Long providerId;
    private String abonentCode;
    private Long paymentAmount;
    private String status;
    private LocalDateTime createTime;
}
