package com.challengehub.challenge_hub.service;

import com.challengehub.challenge_hub.model.Usuario;
import com.challengehub.challenge_hub.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void salvar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
