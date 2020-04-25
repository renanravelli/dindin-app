package br.com.ravellitecnologia.exception;

/**
 * @author renanravelli
 */

public class BussinesException extends RuntimeException {

    public BussinesException(Mensagem message) {
        super(message.getMensagem());
    }
}
