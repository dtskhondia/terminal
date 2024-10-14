package ge.bog.terminal.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Debt {
    private Long terminalId;
    private Long providerId;
    private String abonentCode;
    private String debtAmount;
}
