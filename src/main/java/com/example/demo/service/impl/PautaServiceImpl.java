package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.PautaService;
import com.example.demo.service.validator.PautaValidador;
import com.example.demo.web.rest.dto.SessaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PautaServiceImpl implements PautaService {

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public Pauta cadastrar(Pauta pauta) {
        pauta.obterStatus(pauta);
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta abrirVotacao(SessaoDTO sessaoDTO) {
        Pauta pauta = buscarPorId(sessaoDTO.getIdPauta());
        pauta.abrirVotacao(sessaoDTO);
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta buscarPorId(Long id) {
        return pautaRepository.findById(id).orElseThrow(() -> {
            throw new RuntimeException("Pauta não encontrada");
        });
    }

    @Override
    public List<Pauta> consultarPautasAbertas() {
        return pautaRepository.findAllByStatus("ABERTA");
    }

    @Override
    public Pauta atualizarPauta(Pauta pauta) {
        return this.pautaRepository.save(pauta);
    }
}
