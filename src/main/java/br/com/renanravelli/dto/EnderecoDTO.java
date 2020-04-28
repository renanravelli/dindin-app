package br.com.renanravelli.dto;

import br.com.renanravelli.domain.Estado;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author renanravelli
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

    private Long id;
    private Estado estado;
    private String cidade;
    private String bairro;
    private String endereco;
    private String nro;
    private String cep;
    private String complemento;
}
