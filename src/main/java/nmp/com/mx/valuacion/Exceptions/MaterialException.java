package nmp.com.mx.valuacion.Exceptions;

public class MaterialException extends RuntimeException{
    private String code;

    public MaterialException(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
