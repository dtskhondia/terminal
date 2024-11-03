package ge.bog.terminal.service;

import ge.bog.terminal.domain.Fee;
import ge.bog.terminal.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DebtServiceImpl implements DebtService {
    private final PaymentService paymentService;
    private final FeeService feeService;
    @Override
    public BigDecimal verify(Long terminalId, Long providerId, String abonentCode) {
        List<Payment> paymentList = paymentService.get(terminalId,providerId,abonentCode);
        BigDecimal totalPayment = BigDecimal.ZERO;
        for(Payment payment : paymentList){
            totalPayment = totalPayment.add(payment.getPaymentAmount());
        }

        List<Fee> feeList = feeService.get(terminalId,providerId,abonentCode);
        BigDecimal totalFee = BigDecimal.ZERO;
        for(Fee fee : feeList){
            totalFee = totalFee.add(fee.getFeeAmount());
        }

        return totalPayment.subtract(totalFee);
    }
}
