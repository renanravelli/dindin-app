package br.com.renanravelli.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author renanravelli
 */

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 6046251014902726089L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Length(min = 6, max = 30, message = "O usuário deve ter no mínimo 6 caracteres.")
    @Column(name = "usuario", nullable = false, updatable = false, unique = true)
    private String usuario;
    @Setter
    @NotNull
    @Length(min = 8, max = 100, message = "A senha deve ter no mínimo 8 caracteres.")
    @Column(name = "senha", nullable = false)
    private String senha;
    @Setter
    @Column(name = "foto")
    private byte[] foto;
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private Perfil perfil = Perfil.USUARIO;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, orphanRemoval = true)
    @JoinColumn(name = "id_informacao", referencedColumnName = "id")
    private Informacao informacao;

    public void encryptSenha() {
        this.senha = new BCryptPasswordEncoder().encode(this.senha);
    }
}
