package br.com.renanravelli.ports.driver;

import br.com.renanravelli.domain.Estoque;
import br.com.renanravelli.domain.Sabor;

import java.util.Set;

/**
 * @author renanravelli
 */
public interface EstoqueService {

    Estoque cadastrar(Estoque estoque);

    Estoque atualizar(Estoque estoque);

    Estoque buscar(Long id);

    Boolean disponivel(Sabor sabor);

    Set<Estoque> estoquesDisponiveis();
}
