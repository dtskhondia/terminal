package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.dto.DebtDto;
import ge.bog.terminal.dto.SSTApiDebtDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface DebtMapper {
    DebtDto map(Debt debt);
    Debt map(DebtDto debtDto);

    @Mapping(source = "debtAmount", target = "amount")
    SSTApiDebtDto mapExternal(Debt debt);
    @Mapping(source = "amount", target = "debtAmount")
    Debt mapExternal(SSTApiDebtDto SSTApiDebtDto);
}
