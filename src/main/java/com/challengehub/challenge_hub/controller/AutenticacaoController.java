package com.challengehub.challenge_hub.controller;

import com.challengehub.challenge_hub.config.TokenService;
import com.challengehub.challenge_hub.dto.AuthDto;
import com.challengehub.challenge_hub.dto.TokenDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoController(TokenService tokenService, AuthenticationManager authenticationManager) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<TokenDto> autenticar(@RequestBody AuthDto authDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.getEmail(), authDto.getSenha())
        );
        String token = tokenService.gerarToken(authentication);
        return ResponseEntity.ok(new TokenDto(token));
    }
}
