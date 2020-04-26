package br.com.renanravelli.ports.driver;

import br.com.renanravelli.domain.Solicitacao;

/**
 * @author renanravelli
 */

public interface SolicitacaoService {

    Solicitacao solicitar(Solicitacao solicitacao);

    Solicitacao finalizar(Long id);

    Solicitacao cancelar(Long id);

    Solicitacao buscar(Long id);

}
