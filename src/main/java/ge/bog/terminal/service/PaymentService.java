package ge.bog.terminal.service;

import ge.bog.terminal.domain.Payment;

import java.util.List;

public interface PaymentService {
    Payment pay(Payment payment);
    List<Payment> get(Long TerminalId, Long providerId, String abonentCode);
}
