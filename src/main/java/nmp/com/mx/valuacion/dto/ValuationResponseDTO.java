package nmp.com.mx.valuacion.dto;

import java.math.BigDecimal;

/**
 * DTO para enviar el response de la valuación de la prenda
 * */
public class ValuationResponseDTO {
    private String key;
    private String description;
    private BigDecimal weight;
    private BigDecimal valuePerGram;
    private BigDecimal total;

    public ValuationResponseDTO(String key, String description, BigDecimal weight, BigDecimal valuePerGram, BigDecimal total) {
        this.key = key;
        this.description = description;
        this.valuePerGram = valuePerGram;
        this.total = total;
        this.weight = weight;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValuePerGram() {
        return valuePerGram;
    }

    public void setValuePerGram(BigDecimal valuePerGram) {
        this.valuePerGram = valuePerGram;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }
}
