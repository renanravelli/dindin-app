package br.com.ravellitecnologia.ports.driver;

import br.com.ravellitecnologia.domain.Usuario;
import br.com.ravellitecnologia.dto.LoginDTO;
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
