package ge.bog.terminal.controller;

import ge.bog.terminal.exception.ExceptionResponse;
import ge.bog.terminal.service.DebtService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RequiredArgsConstructor
@RestController
@RequestMapping("/debt")
public class DebtController {
    private final DebtService debtService;

    @Operation(summary = "Verify Debt")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Debt Verified"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Debt Verification Failed",
            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
        ),
        @ApiResponse(
            responseCode = "502",
            description = "SST API Server Error",
            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
        )
    })
    @GetMapping()
    BigDecimal verify(
        @Parameter(name="terminalId", description = "terminal Id", example = "1")
        @RequestParam Long terminalId,
        @Parameter(name="providerId", description = "Provider Id", example = "1")
        @RequestParam Long providerId,
        @Parameter(name="abonentCode", description = "Abonent Code", example = "100000")
        @RequestParam String abonentCode
    ){
        return debtService.verify(terminalId, providerId, abonentCode);
    }
}
