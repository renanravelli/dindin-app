package br.com.renanravelli.dto;

import br.com.renanravelli.domain.Estoque;
import br.com.renanravelli.domain.FormaPagamento;
import br.com.renanravelli.domain.StatusSolicitacao;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author renanravelli
 */

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacaoDTO {

    private Long id;
    private Estoque estoque;
    private Integer quantidade;
    private BigDecimal valorTotal;
    private FormaPagamento formaPagamento;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataSolicitacao;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataEntrega;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataPagamento;
    private StatusSolicitacao status;
}
