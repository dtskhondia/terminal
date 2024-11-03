package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.domain.Payment;

public interface SSTApiService {
    Debt verify(Debt debt);
    Payment pay(Payment payment);
}
