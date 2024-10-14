package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.PaymentDto;
import ge.bog.terminal.dto.PaymentDtoExternal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {
    PaymentDto map(Payment payment);
    Payment map(PaymentDto paymentDto);

    @Mapping(source = "paymentAmount", target = "amount")
    PaymentDtoExternal mapExternal(Payment payment);
    @Mapping(source = "amount", target = "paymentAmount")
    Payment mapExternal(PaymentDtoExternal paymentDtoExternal);
}
