package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Fee;
import ge.bog.terminal.domain.Payment;

import java.util.List;

public interface SSTApiService {
    Payment pay(Payment payment);
    List<Fee> getFees(Long terminalId, Long providerId, String abonentCode);
    List<Payment> getPayments(Long terminalId, Long providerId, String abonentCode);
}
