package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.PaymentDto;
import ge.bog.terminal.dto.SSTApiPaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Payment map(PaymentDto paymentDto);
    PaymentDto map(Payment payment);

    @Mapping(source = "paymentAmount", target = "amount")
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    SSTApiPaymentDto mapExternal(Payment payment);
    @Mapping(source = "amount", target = "paymentAmount")
    Payment mapExternal(SSTApiPaymentDto SSTApiPaymentDto);
}
