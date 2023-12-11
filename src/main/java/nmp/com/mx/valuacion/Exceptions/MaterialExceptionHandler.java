package nmp.com.mx.valuacion.Exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase para manejar las excepciones
 * */
@RestControllerAdvice
public class MaterialExceptionHandler {

    @ExceptionHandler(MaterialException.class)
    public ResponseEntity<ErrorResponse> handleMaterialException(MaterialException materialException) {

        ErrorCode errorCode = ErrorCode.getByCode(materialException.getCode());

        return new ResponseEntity<>(new ErrorResponse(errorCode.getCode(), errorCode.getDescription()), errorCode.getStatus());
    }
}
