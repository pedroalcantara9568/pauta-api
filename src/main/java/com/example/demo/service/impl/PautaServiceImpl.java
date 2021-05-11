package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.PautaService;
import com.example.demo.service.validator.PautaValidador;
import com.example.demo.web.rest.dto.SessaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PautaServiceImpl implements PautaService {

    private final PautaRepository pautaRepository;
    private final PautaValidador pautaValidador;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository,
                            PautaValidador pautaValidador) {
        this.pautaRepository = pautaRepository;
        this.pautaValidador = pautaValidador;
    }

    @Override
    public Pauta cadastrar(Pauta pauta) {
        pauta.obterStatus(pauta);
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta abrirVotacao(SessaoDTO sessaoDTO) {
        Pauta pauta = pautaRepository.findById(sessaoDTO.getIdPauta()).orElseThrow(() -> {
            throw new RuntimeException("Pauta não encontrada");
        });
        pauta.abrirVotacao(sessaoDTO);
        return pautaRepository.save(pauta);
    }
}
