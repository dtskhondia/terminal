package ge.bog.terminal.service;

import ge.bog.terminal.domain.Debt;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DebtServiceImpl implements DebtService {
    @Override
    public Debt verify(Debt debt) {
        return null;
    }
}
