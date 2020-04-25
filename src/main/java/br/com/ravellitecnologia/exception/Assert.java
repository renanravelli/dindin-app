package br.com.ravellitecnologia.exception;

import java.util.Objects;

/**
 * @author renanravelli
 */
public class Assert {

    public static void isNull(Object o, Mensagem mensagem) {
        if (Objects.isNull(o))
            throw new BussinesException(mensagem);
    }

    public static void isTrue(Boolean b, Mensagem mensagem) {
        if (b)
            throw new BussinesException(mensagem);
    }

    public static void isNotNull(Object o, Mensagem mensagem) {
        if (Objects.nonNull(o))
            throw new BussinesException(mensagem);
    }

    public static void equals(Object o1, Object o2, Mensagem mensagem) {
        if (Objects.equals(o1, o2))
            throw new BussinesException(mensagem);
    }
}
