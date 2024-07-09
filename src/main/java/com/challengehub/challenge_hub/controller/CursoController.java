package com.challengehub.challenge_hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challengehub.challenge_hub.model.Curso;
import com.challengehub.challenge_hub.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> criar(@RequestBody Curso curso) {
        Curso cursoSalvo = cursoService.salvar(curso);
        return ResponseEntity.ok(cursoSalvo);
    }
}

