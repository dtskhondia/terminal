package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.PaymentDtoExternal;
import ge.bog.terminal.mapper.DebtMapper;
import ge.bog.terminal.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class SSTApiService {
    @Value("${external-api.sst-service.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;
    private final DebtMapper debtMapper;
    private final PaymentMapper paymentMapper;

    public Debt verify(Debt debt){
        return null;
    }

    public Payment pay(Payment payment){
        return paymentMapper.mapExternal(
            restTemplate.postForEntity(
                baseUrl+"/payments",
                paymentMapper.mapExternal(payment) ,
                PaymentDtoExternal.class
            ).getBody()
        );
    }
}
