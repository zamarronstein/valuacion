package nmp.com.mx.valuacion.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * Clase para manejar los docoumentos de la colección materials
 * */
@Document(collection = "materials")
public class Material {

    @Id
    private String id;
    private String clave;
    private String descripcion;
    private BigDecimal precio;

    public Material(String clave, String descripcion, BigDecimal precio) {
        this.clave = clave;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Material{" +
                "clave='" + clave + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
