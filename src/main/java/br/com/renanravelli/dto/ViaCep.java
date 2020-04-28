package br.com.renanravelli.dto;

import br.com.renanravelli.domain.Estado;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author renanravelli
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViaCep {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private Estado uf;
}
