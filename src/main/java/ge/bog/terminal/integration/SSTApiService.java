package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.PaymentDtoExternal;
import ge.bog.terminal.mapper.DebtMapper;
import ge.bog.terminal.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class SSTApiService {
    @Value("${external-api.sst-service.base-url}")
    private String baseUrl;

    private final RestClient restClient;
    private final DebtMapper debtMapper;
    private final PaymentMapper paymentMapper;

    public Debt verify(Debt debt){
        return null;
    }

    public Payment pay(Payment payment){
        return paymentMapper.mapExternal(
            restClient.post()
                .uri(baseUrl+"/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .body(paymentMapper.mapExternal(payment))
                .retrieve()
                .toEntity(PaymentDtoExternal.class)
                .getBody()
        );
    }
}
