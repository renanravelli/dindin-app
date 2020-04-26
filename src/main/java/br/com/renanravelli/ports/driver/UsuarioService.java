package br.com.renanravelli.ports.driver;

import br.com.renanravelli.domain.Usuario;
import br.com.renanravelli.dto.LoginDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

public interface UsuarioService extends UserDetailsService {

    Usuario cadastrar(Usuario usuario);

    Usuario atualizarPerfil(Usuario usuario);

    void atualizarFoto(MultipartFile foto, Long id);

    LoginDTO atualizarSenha(LoginDTO loginDTO);

    Usuario buscar(Long id);

    Usuario buscar(String usuario);
}
