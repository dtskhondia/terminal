package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Fee;
import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.SSTApiFeeResponseDto;
import ge.bog.terminal.dto.SSTApiPaymentRequestDto;
import ge.bog.terminal.dto.SSTApiPaymentResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface SSTApiMapper {
    @Mapping(source = "paymentAmount", target = "amount")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    SSTApiPaymentRequestDto map(Payment payment);

    @Mapping(target = "terminalId", source = "terminal.id")
    @Mapping(target = "providerId", source = "provider.id")
    @Mapping(source = "amount", target = "paymentAmount")
    Payment map(SSTApiPaymentResponseDto sstApiPaymentResponseDto);

    @Mapping(target = "terminalId", source = "terminal.id")
    @Mapping(target = "providerId", source = "provider.id")
    @Mapping(source = "amount", target = "feeAmount")
    Fee map(SSTApiFeeResponseDto sstApiFeeResponseDto);

    List<Payment> mapPayments(List<SSTApiPaymentResponseDto> sstApiPaymentResponseDto);
    List<Fee> mapFees(List<SSTApiFeeResponseDto> sstApiFeeResponseDto);
}
