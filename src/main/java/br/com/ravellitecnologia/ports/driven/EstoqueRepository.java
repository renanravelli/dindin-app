package br.com.ravellitecnologia.ports.driven;

import br.com.ravellitecnologia.domain.Estoque;
import br.com.ravellitecnologia.domain.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    @Query("FROM Estoque e WHERE e.quantidade > 0 ORDER BY e.sabor.nome")
    Set<Estoque> estoquesDisponiveis();

    @Query("SELECT COUNT(e) > 0 FROM Estoque e WHERE e.sabor = :sabor")
    Boolean disponivel(Sabor sabor);
}
