package br.com.renanravelli.domain;

import br.com.renanravelli.exception.Assert;
import br.com.renanravelli.exception.Mensagem;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author renanravelli
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_SOLICITACAO")
public class Solicitacao implements Serializable {

    private static final long serialVersionUID = 725653536243623785L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @JsonBackReference
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_informacao", referencedColumnName = "id")
    private Informacao informacao;
    @Setter
    @OneToOne(cascade = {CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "id_estoque", referencedColumnName = "id")
    private Estoque estoque;
    @Setter
    @Column(name = "quantidade", nullable = false, updatable = false)
    private Integer quantidade;
    @DecimalMin(value = "000.01")
    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento", nullable = false)
    private FormaPagamento formaPagamento;
    @Column(name = "data_solicitacao", insertable = false, updatable = false)
    private LocalDateTime dataSolicitacao;
    @Column(name = "data_entrega")
    private LocalDateTime dataEntrega;
    @Column(name = "data_pagamento")
    private LocalDateTime dataPagamento;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusSolicitacao status = StatusSolicitacao.EM_ANDAMENTO;
    @Setter
    @Transient
    private String token;

    public void calcularTotal() {
        this.valorTotal = this.estoque.getValor().multiply(BigDecimal.valueOf(quantidade));
    }

    public void finalizar() {
        Assert.equals(this.status, StatusSolicitacao.CANCELADA, Mensagem.SOLICITACAO_CANCELADA);
        Assert.equals(this.status, StatusSolicitacao.FINALIZADA, Mensagem.SOLICITACAO_FINALIZADA);

        if (Objects.isNull(this.dataPagamento))
            this.dataPagamento = LocalDateTime.now();

        this.dataEntrega = LocalDateTime.now();
        this.status = StatusSolicitacao.FINALIZADA;
    }

    public void cancelar() {
        Assert.equals(this.status, StatusSolicitacao.CANCELADA, Mensagem.SOLICITACAO_CANCELADA);
        Assert.equals(this.status, StatusSolicitacao.FINALIZADA, Mensagem.SOLICITACAO_FINALIZADA);
        Assert.isNotNull(this.dataPagamento, Mensagem.PAGAMENTO_JA_EFETUADO);


        this.status = StatusSolicitacao.CANCELADA;
    }
}
