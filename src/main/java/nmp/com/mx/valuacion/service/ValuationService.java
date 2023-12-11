package nmp.com.mx.valuacion.service;

import nmp.com.mx.valuacion.Exceptions.MaterialException;
import nmp.com.mx.valuacion.dto.ValuationResponseDTO;
import nmp.com.mx.valuacion.model.Material;
import nmp.com.mx.valuacion.repository.IMaterialRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Servicio para establecer los métodos de valuación
 * @author jmauricio
 * */
@Service
public class ValuationService {
    /**
     * Se crea el log usando LoggerFactory
     * */
    private static final Logger log = LoggerFactory.getLogger(ValuationService.class);

    /**
     * Referencia a IMaterialRepository
     * */
    private final IMaterialRepository materialRepository;

    @Value("${valuacion.porcentaje}")
    private BigDecimal percentage;

    /**
     * Constructor que inyecta materialRepository
     * @param materialRepository
     * */
    @Autowired
    public ValuationService(IMaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }


    /**
     * Método para calcular el valor de una prenda dependiendo del precio por gramo de material y peso de la prenda
     * @param key - Clave del material
     * @param weight - Peso de la prenda
     * @return ValuationResponseDTO
     * @exception MaterialException
     * */
    public ValuationResponseDTO calculate(String key, BigDecimal weight) {
        log.debug("Start calculate: clave: {}, peso: {}", key, weight);
        Material material = materialRepository.findFirstByClave(key).orElse(null);

        if (material != null) {

            BigDecimal value = material.getPrecio().multiply(weight).multiply(this.percentage.divide(BigDecimal.valueOf(100)));

            return new ValuationResponseDTO(
                    material.getClave(),
                    material.getDescripcion(),
                    weight,
                    material.getPrecio(),
                    value.setScale(2, RoundingMode.HALF_UP)
            );
        } else {
            throw new MaterialException("VALUATION-ERROR-001");
        }
    }
}
