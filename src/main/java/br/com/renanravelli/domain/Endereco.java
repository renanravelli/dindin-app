package br.com.renanravelli.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author renanravelli
 */
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = -8041336426562253067L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "nro")
    private String nro;
    @Column(name = "cep")
    private String cep;
    @Column(name = "complemento")
    private String complemento;
}
