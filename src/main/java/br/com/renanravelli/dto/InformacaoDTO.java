package br.com.renanravelli.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author renanravelli
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacaoDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @NonNull
    private String nome;
    private String documento;
    private LocalDate dataNascimento;
    private String telefone;
    @Email
    @NonNull
    private String email;
    private EnderecoDTO endereco;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Set<SolicitacaoDTO> solicitacoes;
}
