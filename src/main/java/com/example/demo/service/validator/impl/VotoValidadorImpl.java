package com.example.demo.service.validator.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.service.validator.VotoValidador;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo.shared.Constantes.CPF_INVALIDO_EXCEPTION;
import static com.example.demo.shared.Constantes.VOTO_DUPLICADO_EXCEPTION;

@Component
public class VotoValidadorImpl implements VotoValidador {

    private final VotoRepository votoRepository;
    private final CpfValidador cpfValidador;

    @Autowired
    public VotoValidadorImpl(VotoRepository votoRepository,
                             CpfValidador cpfValidador) {
        this.votoRepository = votoRepository;
        this.cpfValidador = cpfValidador;
    }

    @Override
    public void validar(Voto voto) {
        votoRepository.findById(obterVotoId(voto)).ifPresent(voto1 -> {
            throw new VotoDuplicadoException(VOTO_DUPLICADO_EXCEPTION);
        });

        if (cpfValidador.ehValido(voto.getCpf())) {
            throw new CpfInvalidoException(CPF_INVALIDO_EXCEPTION);
        }

    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .cpf(voto.getCpf())
                .idPauta(voto.getIdPauta())
                .build();
    }
}
