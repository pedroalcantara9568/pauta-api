package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaServiceImpl implements PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public Pauta cadastrar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
}
