package com.example.demo.service.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.VotoService;
import org.springframework.stereotype.Component;

@Component
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;

    public VotoServiceImpl(VotoRepository votoRepository) {
        this.votoRepository = votoRepository;
    }

    @Override
    public Voto cadastrar(Voto voto) {
        return votoRepository.save(voto);
    }
}
