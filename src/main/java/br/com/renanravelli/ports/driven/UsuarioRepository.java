package br.com.renanravelli.ports.driven;

import br.com.renanravelli.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuario(String usuario);

    default Boolean existeUsuario(String usuario) {
        return existsByUsuario(usuario);
    }

    default Boolean existeDocumento(String documento) {
        return existsByInformacao_Documento(documento);
    }

    default Boolean existeEmail(String email) {
        return existsByInformacao_Email(email);
    }

    Boolean existsByUsuario(String usuario);

    Boolean existsByInformacao_Documento(String documento);

    Boolean existsByInformacao_Email(String email);

}
