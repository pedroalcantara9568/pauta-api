package com.example.demo.service.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.VotoService;
import com.example.demo.service.validator.PautaValidador;
import com.example.demo.service.validator.VotoValidador;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VotoServiceImpl implements VotoService {

    private final VotoRepository votoRepository;
    private final VotoValidador votoValidador;
    private final PautaValidador pautaValidador;

    public VotoServiceImpl(VotoRepository votoRepository,
                           VotoValidador votoValidador,
                           PautaValidador pautaValidador) {
        this.votoRepository = votoRepository;
        this.votoValidador = votoValidador;
        this.pautaValidador = pautaValidador;
    }

    @Override
    public Optional<Voto> buscarPorId(Voto voto){
        return votoRepository.findById(obterVotoId(voto));
    }

    @Override
    public Voto cadastrar(Voto voto) {
        votoValidador.validar(voto);
        pautaValidador.validar(voto.getIdPauta());
        return votoRepository.save(voto);
    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .cpf(voto.getCpf())
                .idPauta(voto.getIdPauta())
                .build();
    }
}
