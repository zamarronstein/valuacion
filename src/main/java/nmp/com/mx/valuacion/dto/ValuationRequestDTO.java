package nmp.com.mx.valuacion.dto;

import java.math.BigDecimal;

/**
 * DTO para obtener el body del request para hacer el cálculo del valor de la prenda
 * */
public class ValuationRequestDTO {
    private String key;
    private BigDecimal weight;

    public ValuationRequestDTO(String key, BigDecimal weight) {
        this.key = key;
        this.weight = weight;
    }

    public String getKey() {
        return key;
    }

    public BigDecimal getWeight() {
        return weight;
    }
}
