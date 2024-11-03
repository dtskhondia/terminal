package ge.bog.terminal.service;

import ge.bog.terminal.domain.Fee;

import java.util.List;


public interface FeeService {
    List<Fee> get(Long terminalId, Long providerId, String abonetnCode);
}
