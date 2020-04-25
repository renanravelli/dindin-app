package br.com.ravellitecnologia.configuration;

import br.com.ravellitecnologia.domain.Perfil;
import br.com.ravellitecnologia.security.JWTAuthenticationFilter;
import br.com.ravellitecnologia.security.JWTAuthorizationFilter;
import br.com.ravellitecnologia.security.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author renanravelli
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JWTUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    private static final String[] MATCHERS_ADMINISTRADOR = {
            "/administrador/**"
    };

    private static final String[] MATCHERS_USUARIO = {
            "/solicitacao/**",
            "/estoque/",
            "/usuario/perfil",
            "/usuario/atualizar-perfil"
    };

    private static final String[] MATCHERS_MAIN = {
            "/usuario/cadastro",
            "/usuario/recuperar-senha",
            "/usuario/atualizar"
    };

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/")
//                .permitAll();

//                .authorizeRequests()
                .antMatchers(MATCHERS_ADMINISTRADOR)
                .hasAnyAuthority(Perfil.ADMINISTRADOR.name())
                .and()

                .authorizeRequests()
                .antMatchers(MATCHERS_USUARIO)
//                .access("@userSecurity.hasUserId(authentication,#userId)")
                .hasAnyAuthority(Perfil.ADMINISTRADOR.name(), Perfil.USUARIO.name())
                .and()

                .authorizeRequests()
                .antMatchers(MATCHERS_MAIN)
                .permitAll()

                .anyRequest()
                .hasAuthority(Perfil.ADMINISTRADOR.name());

        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {

        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList(
                "Authorization",
                "Cache-Control",
                "Content-Type",
                "Origin",
                "X-Requested-With",
                "Accept"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
