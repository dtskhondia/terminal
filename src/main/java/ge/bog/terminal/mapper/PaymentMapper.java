package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Payment;
import ge.bog.terminal.dto.PaymentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PaymentMapper {
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createTime", ignore = true)
    Payment map(PaymentDto paymentDto);

    PaymentDto map(Payment payment);
}
