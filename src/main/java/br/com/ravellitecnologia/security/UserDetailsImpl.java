package br.com.ravellitecnologia.security;

import br.com.ravellitecnologia.domain.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * @author renanravelli
 */
public class UserDetailsImpl implements UserDetails {

    @Getter
    private Long id;
    private String usuario;
    private String senha;
    private GrantedAuthority authoritie;

    public UserDetailsImpl(Usuario usuario) {
        this.id = usuario.getId();
        this.usuario = usuario.getUsuario();
        this.senha = usuario.getSenha();
        this.authoritie = new SimpleGrantedAuthority(usuario.getPerfil().name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(this.authoritie);
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
