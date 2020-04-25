package br.com.ravellitecnologia.ports.driven;

import br.com.ravellitecnologia.domain.Solicitacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author renanravelli
 */

@Repository
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
}
