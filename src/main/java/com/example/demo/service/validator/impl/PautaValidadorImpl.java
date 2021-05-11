package com.example.demo.service.validator.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.validator.PautaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaValidadorImpl implements PautaValidador {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaValidadorImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public void validar(Long idPauta) {
        Pauta pauta = pautaRepository.findById(idPauta).orElseThrow(() -> {
            throw new RuntimeException("Pauta não encontrada");
        });
        if (pauta.estahFechada()) {
            throw new RuntimeException("Pauta fechada!");
        }
    }

}
