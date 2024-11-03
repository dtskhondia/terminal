package ge.bog.terminal.service;

import java.math.BigDecimal;

public interface DebtService {
    BigDecimal verify(Long terminalId, Long providerId, String abonentCode);
}
