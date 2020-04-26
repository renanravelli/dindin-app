package br.com.renanravelli.domain;

import br.com.renanravelli.exception.BussinesException;
import br.com.renanravelli.exception.Mensagem;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author renanravelli
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_ESTOQUE")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.DETACH, orphanRemoval = true)
    @JoinColumn(name = "id_sabor", referencedColumnName = "id")
    private Sabor sabor;
    @Setter
    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;
    @Setter
    @DecimalMin(value = "000.01")
    @Column(name = "valor", nullable = false)
    private BigDecimal valor;
    @Column(name = "descricao", insertable = false, updatable = false)
    private String descricao;
    @Column(name = "data_registro", insertable = false, updatable = false)
    private LocalDateTime dataRegistro;

    public void diminuir(Integer quantidade) {
        this.quantidade = this.quantidade - quantidade;
        if (this.quantidade < 0) {
            throw new BussinesException(Mensagem.QUANTIDADE_NAO_SUFICIENTE);
        }
    }

    public void adicionar(Integer quantidade) {
        this.quantidade += quantidade;
    }
}
