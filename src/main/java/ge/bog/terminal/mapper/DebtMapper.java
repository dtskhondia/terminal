package ge.bog.terminal.mapper;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.dto.DebtDto;
import ge.bog.terminal.dto.DebtDtoExternal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface DebtMapper {
    DebtDto map(Debt debt);
    Debt map(DebtDto debtDto);

    @Mapping(source = "debtAmount", target = "amount")
    DebtDtoExternal mapExternal(Debt debt);
    @Mapping(source = "amount", target = "debtAmount")
    Debt mapExternal(DebtDtoExternal debtDtoExternal);
}
