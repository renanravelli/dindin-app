package br.com.renanravelli.ports.driver;

import br.com.renanravelli.domain.Sabor;

import java.util.Set;

/**
 * @author renanravelli
 */
public interface SaborService {

    Sabor cadastrar(Sabor sabor);

    Sabor buscar(Long id);

    Set<Sabor> buscarTodos();
}
