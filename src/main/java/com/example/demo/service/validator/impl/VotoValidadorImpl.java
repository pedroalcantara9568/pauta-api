package com.example.demo.service.validator.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.validator.VotoValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VotoValidadorImpl implements VotoValidador {

    private final VotoRepository votoRepository;

    @Autowired
    public VotoValidadorImpl(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    @Override
    public void validar(Voto voto) {
        //TODO: usar validador de CPF para validarVoto
        votoRepository.findById(obterVotoId(voto)).ifPresent(voto1 -> {
            throw new RuntimeException("Voto Duplicado");
        });
    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .cpf(voto.getCpf())
                .idPauta(voto.getIdPauta())
                .build();
    }
}
