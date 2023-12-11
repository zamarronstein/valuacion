package nmp.com.mx.valuacion.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import nmp.com.mx.valuacion.Exceptions.MaterialException;
import nmp.com.mx.valuacion.dto.ValuationRequestDTO;
import nmp.com.mx.valuacion.dto.ValuationResponseDTO;
import nmp.com.mx.valuacion.service.ValuationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Controlador para ejecutar operaciones relacionadas a la valuación de prendas
 * @author jmauricio
 * */
@RestController
@RequestMapping("/valuation")
public class ValuationController {
    private final ValuationService valuationService;

    @Autowired
    public ValuationController(ValuationService valuationService) {
        this.valuationService = valuationService;
    }

    /**
     * Método para calcular el valor de una prenda de acuerdo al material y al peso
     * @param valuationRequestDTO
     * @return ValuationResponseDTO
     * */
    @Operation(summary = "Calcula el valor de una prenda de acuerdo al material y peso", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ValuationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @PostMapping("/calculate")
    public ValuationResponseDTO calcItemValue (@RequestBody ValuationRequestDTO valuationRequestDTO) {

        if(valuationRequestDTO.getKey() == null || valuationRequestDTO.getKey().isEmpty()) {
            throw new MaterialException("VALUATION-ERROR-003");
        }

        if (valuationRequestDTO.getWeight().compareTo(BigDecimal.ZERO) <= 0) {
            throw new MaterialException("VALUATION-ERROR-002");
        }

        return valuationService.calculate(valuationRequestDTO.getKey(), valuationRequestDTO.getWeight());
    }
}
