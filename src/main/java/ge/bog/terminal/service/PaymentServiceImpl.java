package ge.bog.terminal.service;

import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.integration.SSTApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final SSTApiService sstApiService;

    @Override
    public Payment pay(Payment payment) {
        return sstApiService.pay(payment);
    }

    @Override
    public List<Payment> get(Long terminalId, Long providerId, String abonentCode){
        return sstApiService.getPayments(terminalId, providerId, abonentCode);
    }

}
