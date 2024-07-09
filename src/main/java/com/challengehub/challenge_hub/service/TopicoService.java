package com.challengehub.challenge_hub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengehub.challenge_hub.model.Topico;
import com.challengehub.challenge_hub.repository.TopicoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    public Topico salvar(Topico topico) {
        return topicoRepository.save(topico);
    }

    public List<Topico> listar() {
        return topicoRepository.findAll();
    }

    public Optional<Topico> buscarPorId(Long id) {
        return topicoRepository.findById(id);
    }

    public void deletar(Long id) {
        topicoRepository.deleteById(id);
    }

    public Topico atualizar(Long id, Topico topico) {
        topico.setId(id);
        return topicoRepository.save(topico);
    }
}
