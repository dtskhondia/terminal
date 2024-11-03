package ge.bog.terminal.integration;

import ge.bog.terminal.domain.Fee;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.SSTApiFeeResponseDto;
import ge.bog.terminal.dto.SSTApiPaymentResponseDto;
import ge.bog.terminal.exception.SSTApiClientException;
import ge.bog.terminal.exception.SSTApiExceptionResponse;
import ge.bog.terminal.exception.SSTApiServerException;
import ge.bog.terminal.mapper.PaymentMapper;
import ge.bog.terminal.mapper.SSTApiMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class SSTApiServiceImpl implements SSTApiService {
    @Value("${external-api.sst-service.base-url}")
    private String baseUrl;

    private final RestClient restClient;
    private final SSTApiMapper sstApiMapper;

    public Payment pay(Payment payment) {
        return restClient.post()
            .uri(baseUrl+"/payments")
            .contentType(MediaType.APPLICATION_JSON)
            .body(sstApiMapper.map(payment))
            .exchange((clientRequest, clientResponse) -> {
                if(clientResponse.getStatusCode().is4xxClientError()){
                    SSTApiExceptionResponse sstApiExceptionResponse = clientResponse.bodyTo(SSTApiExceptionResponse.class);
                    throw new SSTApiClientException(sstApiExceptionResponse.errorMessage(),sstApiExceptionResponse.errorCode());
                } else if(clientResponse.getStatusCode().is5xxServerError()){
                    throw new SSTApiServerException("SST API Server Error: ");
                }
                else{
                    SSTApiPaymentResponseDto sstApiPaymentResponseDto = clientResponse.bodyTo(SSTApiPaymentResponseDto.class);
                    return sstApiMapper.map(sstApiPaymentResponseDto);
                }
            });
    }

    public List<Fee> getFees(Long terminalId, Long providerId, String abonentCode){
        URI uri = UriComponentsBuilder
            .fromUriString(baseUrl+"/fees?terminalId={terminalId}&providerId={providerId}&abonentCode={abonentCode}")
            .build(terminalId, providerId, abonentCode);

        return restClient.get()
            .uri(uri)
            .exchange((clientRequest, clientResponse) -> {
                if(clientResponse.getStatusCode().is4xxClientError()){
                    SSTApiExceptionResponse sstApiExceptionResponse = clientResponse.bodyTo(SSTApiExceptionResponse.class);
                    throw new SSTApiClientException(sstApiExceptionResponse.errorMessage(),sstApiExceptionResponse.errorCode());
                } else if(clientResponse.getStatusCode().is5xxServerError()){
                    throw new SSTApiServerException("SST API Server Error: ");
                }
                else{
                    List<SSTApiFeeResponseDto> sstApiFeeResponseDto = Arrays.asList(clientResponse.bodyTo(SSTApiFeeResponseDto[].class));
                    return sstApiMapper.mapFees(sstApiFeeResponseDto);
                }
            });
    }

    public List<Payment> getPayments(Long terminalId, Long providerId, String abonentCode){
        URI uri = UriComponentsBuilder
            .fromUriString(baseUrl+"/payments?terminalId={terminalId}&providerId={providerId}&abonentCode={abonentCode}")
            .build(terminalId, providerId, abonentCode);

        return restClient.get()
            .uri(uri)
            .exchange((clientRequest, clientResponse) -> {
                if(clientResponse.getStatusCode().is4xxClientError()){
                    SSTApiExceptionResponse sstApiExceptionResponse = clientResponse.bodyTo(SSTApiExceptionResponse.class);
                    throw new SSTApiClientException(sstApiExceptionResponse.errorMessage(),sstApiExceptionResponse.errorCode());
                } else if(clientResponse.getStatusCode().is5xxServerError()){
                    throw new SSTApiServerException("SST API Server Error: ");
                }
                else{
                    List<SSTApiPaymentResponseDto> sstApiPaymentResponseDto = Arrays.asList(clientResponse.bodyTo(SSTApiPaymentResponseDto[].class));
                    return sstApiMapper.mapPayments(sstApiPaymentResponseDto);
                }
            });
    }

}
