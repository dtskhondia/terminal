package ge.bog.terminal.config;

import ge.bog.terminal.mapper.DebtMapper;
import ge.bog.terminal.mapper.PaymentMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public PaymentMapper paymentMapper() {return Mappers.getMapper(PaymentMapper.class); }

    @Bean
    public DebtMapper debtMapper() {return Mappers.getMapper(DebtMapper.class); }
}
