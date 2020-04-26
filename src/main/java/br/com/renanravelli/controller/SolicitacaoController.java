package br.com.renanravelli.controller;

import br.com.renanravelli.domain.Solicitacao;
import br.com.renanravelli.dto.SolicitacaoDTO;
import br.com.renanravelli.dto.mapper.SolicitacaoMapper;
import br.com.renanravelli.ports.driver.SolicitacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author renanravelli
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/solicitacao")
public class SolicitacaoController {

    private final SolicitacaoMapper solicitacaoMapper;
    private final SolicitacaoService solicitacaoService;

    @PostMapping(
            value = "/solicitar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SolicitacaoDTO> solicitar(@RequestHeader("Authorization") String token,
                                                    @RequestBody Solicitacao solicitacao) {

        solicitacao.setToken(token);
        Solicitacao solicitacaoRealizada = this.solicitacaoService.solicitar(solicitacao);
        SolicitacaoDTO solicitacaoDTO = this.solicitacaoMapper.toDTO(solicitacaoRealizada);

        return ResponseEntity.ok(solicitacaoDTO);
    }

    @PutMapping(value = "/finalizar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SolicitacaoDTO> finalizar(@RequestBody Solicitacao solicitacao) {

        Solicitacao solicitacaoAtualizada = this.solicitacaoService.finalizar(solicitacao.getId());
        SolicitacaoDTO solicitacaoDTO = this.solicitacaoMapper.toDTO(solicitacaoAtualizada);

        return ResponseEntity.ok(solicitacaoDTO);
    }

    @PutMapping(value = "/cancelar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<SolicitacaoDTO> cancelar(@RequestBody Solicitacao solicitacao) {

        solicitacao.cancelar();
        Solicitacao solicitacaoAtualizada = this.solicitacaoService.cancelar(solicitacao.getId());
        SolicitacaoDTO solicitacaoDTO = this.solicitacaoMapper.toDTO(solicitacaoAtualizada);

        return ResponseEntity.ok(solicitacaoDTO);
    }
}
