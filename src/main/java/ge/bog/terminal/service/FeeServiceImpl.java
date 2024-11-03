package ge.bog.terminal.service;

import ge.bog.terminal.domain.Fee;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.integration.SSTApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FeeServiceImpl implements FeeService {
    private final SSTApiService sstApiService;

    @Override
    public List<Fee> get(Long terminalId, Long providerId, String abonentCode) {
        return sstApiService.getFees(terminalId,providerId, abonentCode);
    }
}
