package br.com.ravellitecnologia.ports.driver;

import br.com.ravellitecnologia.domain.Sabor;

import java.util.Set;

/**
 * @author renanravelli
 */
public interface SaborService {

    Sabor cadastrar(Sabor sabor);

    Sabor buscar(Long id);

    Set<Sabor> buscarTodos();
}
