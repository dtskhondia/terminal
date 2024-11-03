package ge.bog.terminal.controller;

import ge.bog.terminal.dto.PaymentDto;
import ge.bog.terminal.exception.ExceptionResponse;
import ge.bog.terminal.mapper.PaymentMapper;
import ge.bog.terminal.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @Operation(summary = "Debt Payment")
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Payment Completed"
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Payment Failed",
            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
        ),
        @ApiResponse(
            responseCode = "502",
            description = "SST API Server Error",
            content = @Content(schema = @Schema(implementation = ExceptionResponse.class))
        )
    })
    @PostMapping("/")
    PaymentDto pay(
        @Parameter(description = "Payment Object")
        @RequestBody @Valid PaymentDto paymentDto
    ){
        return paymentMapper.map(paymentService.pay(paymentMapper.map(paymentDto)));
    }
}
