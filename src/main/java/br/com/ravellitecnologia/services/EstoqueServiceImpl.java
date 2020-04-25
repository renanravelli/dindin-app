package br.com.ravellitecnologia.services;

import br.com.ravellitecnologia.domain.Estoque;
import br.com.ravellitecnologia.domain.Sabor;
import br.com.ravellitecnologia.exception.Assert;
import br.com.ravellitecnologia.exception.BussinesException;
import br.com.ravellitecnologia.exception.Mensagem;
import br.com.ravellitecnologia.ports.driven.EstoqueRepository;
import br.com.ravellitecnologia.ports.driver.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository repository;

    @Override
    @Transactional
    public Estoque cadastrar(Estoque estoque) {
        Assert.isNull(estoque, Mensagem.DADOS_DO_SABOR_NAO_INFORMADO);

        Boolean disponivel = disponivel(estoque.getSabor());
        Assert.isTrue(disponivel, Mensagem.SABOR_EM_ESTOQUE);

        return this.repository.save(estoque);
    }

    @Override
    @Transactional
    public Estoque atualizar(Estoque estoque) {
        Assert.isNull(estoque.getId(), Mensagem.ESTOQUE_NAO_ENCONTRADO);

        Estoque estoqueEncontrado = buscar(estoque.getId());
        estoqueEncontrado.setQuantidade(estoque.getQuantidade());
        estoqueEncontrado.setValor(estoque.getValor());

        return this.repository.save(estoqueEncontrado);
    }

    @Override
    public Estoque buscar(Long id) {
        Assert.isNull(id, Mensagem.DADOS_DO_ESTOQUE_NAO_INFORMADO);
        return this.repository.findById(id)
                .orElseThrow(() -> new BussinesException(Mensagem.ESTOQUE_NAO_ENCONTRADO));
    }

    @Override
    public Boolean disponivel(Sabor sabor) {
        Boolean disponivel = this.repository.disponivel(sabor);
        return disponivel;
    }

    @Override
    public Set<Estoque> estoquesDisponiveis() {
        return this.repository.estoquesDisponiveis();
    }
}
