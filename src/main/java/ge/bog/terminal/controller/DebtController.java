package ge.bog.terminal.controller;

import ge.bog.terminal.domain.Debt;
import ge.bog.terminal.dto.DebtDto;
import ge.bog.terminal.mapper.DebtMapper;
import ge.bog.terminal.service.DebtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/debt")
public class DebtController {
    private final DebtService debtService;
    private final DebtMapper debtMapper;

    @Operation(summary = "Verify Debt")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Debt Verified"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Debt Verification Failed"
        )
    })
    @GetMapping
    DebtDto verify(
        @Parameter(description = "Debt to to verified")
        @RequestBody @Valid DebtDto debtDto
    ){
        return debtMapper.map(debtService.verify(debtMapper.map(debtDto)));
    }
}
