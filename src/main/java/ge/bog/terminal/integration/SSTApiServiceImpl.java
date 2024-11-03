package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.SSTApiPaymentDto;
import ge.bog.terminal.exception.SSTApiClientException;
import ge.bog.terminal.exception.SSTApiExceptionResponse;
import ge.bog.terminal.exception.SSTApiServerException;
import ge.bog.terminal.mapper.DebtMapper;
import ge.bog.terminal.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@Primary
@RequiredArgsConstructor
public class SSTApiServiceImpl implements SSTApiService {
    @Value("${external-api.sst-service.base-url}")
    private String baseUrl;

    private final RestClient restClient;
    private final DebtMapper debtMapper;
    private final PaymentMapper paymentMapper;

    public Debt verify(Debt debt){
        return null;
    }

    public Payment pay(Payment payment) {
        return restClient.post()
            .uri(baseUrl+"/payments")
            .contentType(MediaType.APPLICATION_JSON)
            .body(paymentMapper.mapExternal(payment))
            .exchange((clientRequest, clientResponse) -> {
                if(clientResponse.getStatusCode().is4xxClientError()){
                    SSTApiExceptionResponse sstApiExceptionResponse = clientResponse.bodyTo(SSTApiExceptionResponse.class);
                    throw new SSTApiClientException(sstApiExceptionResponse.errorMessage(),sstApiExceptionResponse.errorCode());
                } else if(clientResponse.getStatusCode().is5xxServerError()){
                    throw new SSTApiServerException("SST API Server Error: ");
                }
                else{
                    SSTApiPaymentDto SSTApiPaymentDto = clientResponse.bodyTo(SSTApiPaymentDto.class);
                    return paymentMapper.mapExternal(SSTApiPaymentDto);
                }
            });
    }
}
