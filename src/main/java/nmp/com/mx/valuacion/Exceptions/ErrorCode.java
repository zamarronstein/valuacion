package nmp.com.mx.valuacion.Exceptions;

import org.springframework.http.HttpStatus;

import java.util.Arrays;

/**
 * Enum para establecer los códigos de error, la descripción y el estatus a retornar
 * */
public enum ErrorCode {
    ERROR_CODE_1("VALUATION-ERROR-001", "No se encontró la clave del material", HttpStatus.NOT_FOUND),
    ERROR_CODE_2("VALUATION-ERROR-002", "El Valor de gramos debe ser un número positivo", HttpStatus.BAD_REQUEST),
    ERROR_CODE_3("VALUATION-ERROR-003", "La clave no puede estar vacía", HttpStatus.BAD_REQUEST),
    ERROR_CODE_DEFAULT("VALUATION-ERROR-000", "Ha ocurrido un error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String code;
    private final String description;
    private final HttpStatus status;

    ErrorCode(String code, String description, HttpStatus status) {
        this.code = code;
        this.description = description;
        this.status = status;

    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public static ErrorCode getByCode(String code) {
        return Arrays.stream(values())
                .filter(errorCode -> errorCode.getCode().equals(code))
                .findFirst()
                .orElse(ERROR_CODE_DEFAULT);
    }
}
