package br.com.renanravelli.controller;

import br.com.renanravelli.domain.Estoque;
import br.com.renanravelli.ports.driver.EstoqueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author renanravelli
 */

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @GetMapping(value = "/",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Set<Estoque>> cardapio() {

        Set<Estoque> estoque = this.estoqueService.estoquesDisponiveis();

        return ResponseEntity.ok(estoque);
    }

    @PostMapping(
            value = "/cadastro",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Estoque> cadastrar(@RequestBody Estoque estoque) {

        Estoque estoqueCadastrado = this.estoqueService.cadastrar(estoque);

        return ResponseEntity.ok(estoqueCadastrado);
    }

    @PutMapping(
            value = "/atualizar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Estoque> atualizar(@RequestBody Estoque estoque) {

        Estoque estoqueAtualizado = this.estoqueService.atualizar(estoque);

        return ResponseEntity.ok(estoqueAtualizado);
    }
}
