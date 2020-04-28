package br.com.renanravelli.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author renanravelli
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_informacao")
public class Informacao implements Serializable {

    private static final long serialVersionUID = -1967861410015079009L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "documento")
    private String documento;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email", nullable = false)
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id")
    private Endereco endereco;
    @JsonManagedReference
    @OrderBy("dataSolicitacao desc")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, mappedBy = "informacao")
    private List<Solicitacao> solicitacoes = new ArrayList<>();
}
