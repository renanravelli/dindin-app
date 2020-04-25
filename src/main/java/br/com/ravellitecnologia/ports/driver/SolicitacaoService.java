package br.com.ravellitecnologia.ports.driver;

import br.com.ravellitecnologia.domain.Solicitacao;

/**
 * @author renanravelli
 */

public interface SolicitacaoService {

    Solicitacao solicitar(Solicitacao solicitacao);

    Solicitacao finalizar(Long id);

    Solicitacao cancelar(Long id);

    Solicitacao buscar(Long id);

}
