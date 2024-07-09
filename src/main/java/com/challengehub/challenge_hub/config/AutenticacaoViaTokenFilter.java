package com.challengehub.challenge_hub.config;

import com.challengehub.challenge_hub.model.Usuario;
import com.challengehub.challenge_hub.repository.UsuarioRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AutenticacaoViaTokenFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenService tokenService;
    private final UsuarioRepository usuarioRepository;

    public AutenticacaoViaTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        super("/**"); // Aplica este filtro a todas las solicitudes
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String token = resolveToken(request);
        if (token != null && tokenService.isTokenValido(token)) {
            Long usuarioId = tokenService.getIdUsuario(token);
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            UserDetails userDetails = org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getEmail())
                    .password(usuario.getPassword())
                    .authorities(usuario.getAuthorities())
                    .build();

            Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        return null;
    }

    private String resolveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        return (token != null && token.startsWith("Bearer ")) ? token.substring(7) : null;
    }
}
