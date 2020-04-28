package br.com.renanravelli.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author renanravelli
 */
@Getter
@AllArgsConstructor
public enum StatusSolicitacao {

    EM_ANDAMENTO("Em andamento"),
    CANCELADA("Cancelada"),
    FINALIZADA("Finalizada");

    private String descricao;
}
