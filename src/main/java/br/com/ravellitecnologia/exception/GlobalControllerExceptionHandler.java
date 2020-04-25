package br.com.ravellitecnologia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author renanravelli
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(BussinesException.class)
    public ResponseEntity<?> handleConflict(BussinesException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
