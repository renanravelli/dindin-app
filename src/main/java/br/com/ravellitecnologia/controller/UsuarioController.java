package br.com.ravellitecnologia.controller;

import br.com.ravellitecnologia.domain.Usuario;
import br.com.ravellitecnologia.dto.LoginDTO;
import br.com.ravellitecnologia.dto.UsuarioDTO;
import br.com.ravellitecnologia.dto.mapper.UsuarioMapper;
import br.com.ravellitecnologia.exception.Assert;
import br.com.ravellitecnologia.exception.Mensagem;
import br.com.ravellitecnologia.ports.driver.UsuarioService;
import br.com.ravellitecnologia.security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @author renanravelli
 */

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/usuario")
public class UsuarioController {

    private final JWTUtil jwtUtil;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioService usuarioService;

    @PostMapping(value = "/cadastro",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody Usuario usuario) {

        Usuario usuarioCadastrado = this.usuarioService.cadastrar(usuario);
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuarioCadastrado);

        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping(value = "/atualizar-perfil",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> atualizarPefil(@RequestBody Usuario usuario) {

        Usuario usuarioAtualizado = this.usuarioService.atualizarPerfil(usuario);
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuarioAtualizado);

        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping(value = "/atualizar-foto/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> atualizarFoto(@RequestParam("foto") MultipartFile foto,
                                           @PathVariable("id") Long id) {

        this.usuarioService.atualizarFoto(foto, id);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/atualizar-senha",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<LoginDTO> atualizarSenha(@RequestBody LoginDTO loginDTO) {

        LoginDTO dto = this.usuarioService.atualizarSenha(loginDTO);

        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/perfil",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> perfil(@RequestHeader("Authorization") String token) {

        String username = jwtUtil.getUsername(token.substring(7));
        UsuarioDTO usuarioDTO = buscarUsuario(null, username);

        return ResponseEntity.ok(usuarioDTO);
    }

    @GetMapping(value = "/buscar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UsuarioDTO> buscar(@Param("id") Long id,
                                             @Param("usuario") String usuario) {
        UsuarioDTO usuarioDTO = buscarUsuario(id, usuario);

        return ResponseEntity.ok(usuarioDTO);
    }

    private UsuarioDTO buscarUsuario(Long id, String usuario) {
        Usuario usuarioCadastrado = null;
        if (Objects.nonNull(id)) {
            usuarioCadastrado = this.usuarioService.buscar(id);
        } else if (Objects.nonNull(usuario)) {
            usuarioCadastrado = this.usuarioService.buscar(usuario);
        }

        Assert.isNull(usuarioCadastrado, Mensagem.USUARIO_NAO_ENCONTRADO);
        UsuarioDTO usuarioDTO = usuarioMapper.toDTO(usuarioCadastrado);

        return usuarioDTO;
    }
}
