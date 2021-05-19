package com.example.demo.service.validator.impl;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.service.validator.VotoValidador;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import com.example.demo.web.rest.exception.VotoInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.example.demo.shared.Constantes.*;

@Component
public class VotoValidadorImpl implements VotoValidador {

    private static final Logger logger = LoggerFactory.getLogger(VotoValidadorImpl.class);

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
        logger.info("validando voto: " + voto);
        Optional<Voto> votoConsultado = votoRepository.findById(obterVotoId(voto));
        validar(voto.getVoto());
        if (votoConsultado.isPresent()) {
            throw new VotoDuplicadoException(VOTO_DUPLICADO_EXCEPTION);
        }
        cpfValidador.validar(voto.getCpf());
    }

    private void validar(String voto) {
        if(!(voto.equals(SIM) || voto.equals(NAO))){
            throw new VotoInvalidoException(VOTO_INVALIDO_EXCEPTION);
        }
    }

    private VotoPK obterVotoId(Voto voto) {
        return VotoPK.builder()
                .idCooperado(voto.getIdCooperado())
                .idPauta(voto.getIdPauta())
                .build();
    }


}
