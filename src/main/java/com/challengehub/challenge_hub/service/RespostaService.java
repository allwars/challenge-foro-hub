package com.challengehub.challenge_hub.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challengehub.challenge_hub.model.Resposta;
import com.challengehub.challenge_hub.repository.RespostaRepository;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    public Resposta salvar(Resposta resposta) {
        return respostaRepository.save(resposta);
    }
}
