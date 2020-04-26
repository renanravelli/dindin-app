package br.com.renanravelli.services;

import br.com.renanravelli.domain.Estoque;
import br.com.renanravelli.domain.Solicitacao;
import br.com.renanravelli.domain.Usuario;
import br.com.renanravelli.exception.Assert;
import br.com.renanravelli.exception.BussinesException;
import br.com.renanravelli.exception.Mensagem;
import br.com.renanravelli.ports.driven.SolicitacaoRepository;
import br.com.renanravelli.ports.driver.EstoqueService;
import br.com.renanravelli.ports.driver.SolicitacaoService;
import br.com.renanravelli.ports.driver.UsuarioService;
import br.com.renanravelli.security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class SolicitacaoServiceImpl implements SolicitacaoService {

    private final JWTUtil jwtUtil;
    private final UsuarioService usuarioService;
    private final EstoqueService estoqueService;
    private final SolicitacaoRepository repository;

    @Override
    @Transactional
    public Solicitacao solicitar(Solicitacao solicitacao) {
        Assert.isNull(solicitacao, Mensagem.DADOS_DA_SOLICITACAO_NAO_INFORMADO);

        Estoque estoque = this.estoqueService.buscar(solicitacao.getEstoque().getId());
        estoque.diminuir(solicitacao.getQuantidade());

        String token = solicitacao.getToken().substring(7);
        String username = this.jwtUtil.getUsername(token);
        Usuario usuario = this.usuarioService.buscar(username);

        solicitacao.setEstoque(estoque);
        solicitacao.setInformacao(usuario.getInformacao());
        solicitacao.calcularTotal();

        return this.repository.save(solicitacao);
    }

    @Override
    @Transactional
    public Solicitacao finalizar(Long id) {
        Solicitacao solicitacao = buscar(id);
        solicitacao.finalizar();

        return this.repository.save(solicitacao);
    }

    @Override
    @Transactional
    public Solicitacao cancelar(Long id) {

        Solicitacao solicitacao = Solicitacao.builder()
                .id(id)
                .build();

        Solicitacao solicitacaoEncontrada = buscar(solicitacao.getId());
        Estoque estoque = solicitacaoEncontrada.getEstoque();
        estoque.adicionar(solicitacaoEncontrada.getQuantidade());
        solicitacaoEncontrada.cancelar();

        return this.repository.save(solicitacaoEncontrada);
    }

    @Override
    public Solicitacao buscar(Long id) {
        Assert.isNull(id, Mensagem.DADOS_DA_SOLICITACAO_NAO_INFORMADO);
        return this.repository.findById(id)
                .orElseThrow(() -> new BussinesException(Mensagem.SOLICITACAO_NAO_ENCONTRADA));
    }
}