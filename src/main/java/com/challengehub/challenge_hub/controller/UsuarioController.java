package com.challengehub.challenge_hub.controller;

import com.challengehub.challenge_hub.model.Usuario;
import com.challengehub.challenge_hub.service.UsuarioService;
import com.challengehub.challenge_hub.dto.UsuarioDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioDto usuarioDto) {
        Usuario usuario = new Usuario(usuarioDto.getEmail(), usuarioDto.getSenha(), usuarioDto.getNome());
        usuarioService.salvar(usuario);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarTodos();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
