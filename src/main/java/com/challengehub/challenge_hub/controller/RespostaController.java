package com.challengehub.challenge_hub.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.challengehub.challenge_hub.model.Resposta;
import com.challengehub.challenge_hub.service.RespostaService;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public ResponseEntity<Resposta> criar(@RequestBody Resposta resposta) {
        Resposta respostaSalva = respostaService.salvar(resposta);
        return ResponseEntity.ok(respostaSalva);
    }
}
