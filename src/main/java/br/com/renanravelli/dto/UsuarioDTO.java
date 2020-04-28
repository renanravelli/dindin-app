package br.com.renanravelli.dto;

import br.com.renanravelli.domain.Perfil;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

/**
 * @author renanravelli
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @NonNull
    private String usuario;
    @NonNull
    private String senha;
    private byte[] foto;
    private Perfil perfil;
    private InformacaoDTO informacao;
}
