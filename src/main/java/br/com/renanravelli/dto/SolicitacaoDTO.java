package br.com.renanravelli.dto;

import br.com.renanravelli.domain.Estoque;
import br.com.renanravelli.domain.FormaPagamento;
import br.com.renanravelli.domain.StatusSolicitacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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
    private String formaPagamento;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataSolicitacao;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataEntrega;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime dataPagamento;
    private String status;
}
