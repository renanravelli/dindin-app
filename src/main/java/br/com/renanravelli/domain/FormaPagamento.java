package br.com.renanravelli.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author renanravelli
 */

@Getter
@AllArgsConstructor
public enum FormaPagamento {

    CREDITO("Crédito"),
    DEBITO("Débito"),
    DINHEIRO("Dinheiro"),
    APLICATIVO("Aplicativo");

    private String descricao;
}
