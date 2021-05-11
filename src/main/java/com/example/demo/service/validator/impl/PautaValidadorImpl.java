package com.example.demo.service.validator.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.service.PautaService;
import com.example.demo.service.validator.PautaValidador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaValidadorImpl implements PautaValidador {

    private final PautaService pautaService;

    @Autowired
    public PautaValidadorImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Override
    public void validar(Long idPauta) {
        Pauta pauta = pautaService.buscarPorId(idPauta);
        if (pauta.estahFechada()) {
            throw new RuntimeException("Pauta fechada!");
        }
    }

}
