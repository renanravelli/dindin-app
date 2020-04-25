package br.com.ravellitecnologia.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author renanravelli
 */

@AllArgsConstructor
public class Response {

    private String mensagem;
    private HttpStatus status;
}
