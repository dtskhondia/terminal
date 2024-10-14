package ge.bog.terminal.service;

import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.integration.SSTApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final SSTApiService sstApiService;

    @Override
    public Payment pay(Payment payment) {
        return sstApiService.pay(payment);
    }
}
