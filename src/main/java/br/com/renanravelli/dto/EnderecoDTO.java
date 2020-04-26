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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @NonNull
    private Estado estado;
    @NonNull
    private String cidade;
    @NonNull
    private String bairro;
    @NonNull
    private String endereco;
    @NonNull
    private String cep;
}
