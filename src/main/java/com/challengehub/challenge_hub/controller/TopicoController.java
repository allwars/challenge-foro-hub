package com.challengehub.challenge_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challengehub.challenge_hub.model.Topico;
import com.challengehub.challenge_hub.service.TopicoService;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    public ResponseEntity<Topico> criar(@RequestBody Topico topico) {
        Topico topicoSalvo = topicoService.salvar(topico);
        return ResponseEntity.ok(topicoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listar() {
        List<Topico> topicos = topicoService.listar();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> buscarPorId(@PathVariable Long id) {
        return topicoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> atualizar(@PathVariable Long id, @RequestBody Topico topico) {
        Topico topicoAtualizado = topicoService.atualizar(id, topico);
        return ResponseEntity.ok(topicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        topicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
