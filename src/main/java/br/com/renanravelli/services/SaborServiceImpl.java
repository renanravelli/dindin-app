package br.com.renanravelli.services;

import br.com.renanravelli.domain.Sabor;
import br.com.renanravelli.exception.Assert;
import br.com.renanravelli.exception.BussinesException;
import br.com.renanravelli.exception.Mensagem;
import br.com.renanravelli.ports.driven.SaborRepository;
import br.com.renanravelli.ports.driver.SaborService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class SaborServiceImpl implements SaborService {

    private final SaborRepository repository;

    @Override
    @Transactional
    public Sabor cadastrar(Sabor sabor) {
        Assert.isNull(sabor, Mensagem.DADOS_DO_SABOR_NAO_INFORMADO);
        return this.repository.save(sabor);
    }

    @Override
    public Sabor buscar(Long id) {
        Assert.isNull(id, Mensagem.DADOS_DO_SABOR_NAO_INFORMADO);
        return this.repository.findById(id)
                .orElseThrow(() -> new BussinesException(Mensagem.SABOR_NAO_ENCONTRADO));
    }

    @Override
    public Set<Sabor> buscarTodos() {
        return new HashSet<>(this.repository.findAll());
    }
}
