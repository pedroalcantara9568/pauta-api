package com.example.demo.service.validator.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.service.VotoService;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.service.validator.VotoValidador;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.demo.shared.Constantes.VOTO_DUPLICADO_EXCEPTION;

@Component
public class VotoValidadorImpl implements VotoValidador {

    private final VotoService votoService;
    private final CpfValidador cpfValidador;

    @Autowired
    public VotoValidadorImpl(VotoService votoService,
                             CpfValidador cpfValidador) {
        this.votoService = votoService;
        this.cpfValidador = cpfValidador;
    }

    @Override
    public void validar(Voto voto) {
        Optional<Voto> votoConsultado = votoService.buscarPorId(voto);
        if (votoConsultado.isPresent()) {
            throw new VotoDuplicadoException(VOTO_DUPLICADO_EXCEPTION);
        }
        cpfValidador.validar(voto.getCpf());
    }


}
