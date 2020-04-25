package br.com.ravellitecnologia.services;

import br.com.ravellitecnologia.domain.Usuario;
import br.com.ravellitecnologia.dto.LoginDTO;
import br.com.ravellitecnologia.dto.mapper.LoginMapper;
import br.com.ravellitecnologia.exception.Assert;
import br.com.ravellitecnologia.exception.BussinesException;
import br.com.ravellitecnologia.exception.Mensagem;
import br.com.ravellitecnologia.ports.driven.UsuarioRepository;
import br.com.ravellitecnologia.ports.driver.UsuarioService;
import br.com.ravellitecnologia.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author renanravelli
 */

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    @Value("${storage}")
    private String storage;
    private final LoginMapper loginMapper;
    private final UsuarioRepository repository;

    @Override
    @Transactional
    public Usuario cadastrar(Usuario usuario) {
        Assert.isNull(usuario, Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);

        // validacao
        Boolean existeUsuario = this.repository.existeUsuario(usuario.getUsuario());
//        Boolean existeDocumento = this.repository.existeDocumento(usuario.getInformacao().getDocumento());
        Boolean existeEmail = this.repository.existeEmail(usuario.getInformacao().getEmail());

        Assert.isTrue(existeUsuario, Mensagem.USUARIO_JA_CADASTRADO);
//        Assert.isTrue(existeDocumento, Mensagem.DOCUMENTO_JA_CADASTRADO);
        Assert.isTrue(existeEmail, Mensagem.EMAIL_JA_CADASTRADO);

        usuario.encryptSenha();

        return this.repository.save(usuario);
    }

    @Override
    @Transactional
    public Usuario atualizarPerfil(Usuario usuario) {
        Assert.isNull(usuario.getId(), Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);
        Assert.isNull(usuario.getUsuario(), Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);

        return this.repository.save(usuario);
    }

    @SneakyThrows
    @Override
    public void atualizarFoto(MultipartFile foto, Long id) {
        Usuario usuario = buscar(id);
        usuario.setFoto(foto.getBytes());

        this.repository.save(usuario);
    }

    @Override
    @Transactional
    public LoginDTO atualizarSenha(LoginDTO loginDTO) {
        Assert.isNull(loginDTO.getUsuario(), Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);

        Usuario usuarioEncontrado = buscar(loginDTO.getUsuario());
        usuarioEncontrado.setSenha(loginDTO.getSenha());
        usuarioEncontrado.encryptSenha();

        Usuario usuario = this.repository.save(usuarioEncontrado);

        return this.loginMapper.toDTO(usuario);
    }

    @Override
    public Usuario buscar(Long id) {
        Assert.isNull(id, Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);
        return this.repository.findById(id)
                .orElseThrow(() -> new BussinesException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

    @Override
    public Usuario buscar(String usuario) {
        Assert.isNull(usuario, Mensagem.DADOS_DO_USUARIO_NAO_INFORMADO);
        return this.repository.findByUsuario(usuario)
                .orElseThrow(() -> new BussinesException(Mensagem.USUARIO_NAO_ENCONTRADO));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new UserDetailsImpl(buscar(s));
    }
}
