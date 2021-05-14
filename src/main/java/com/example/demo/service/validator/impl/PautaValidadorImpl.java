package com.example.demo.service.validator.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.service.PautaService;
import com.example.demo.service.impl.PautaServiceImpl;
import com.example.demo.service.validator.PautaValidador;
import com.example.demo.web.rest.exception.SessaoFechadaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.demo.shared.Constantes.SESSAO_FECHADA_EXCEPTION;

@Component
public class PautaValidadorImpl implements PautaValidador {


    private static final Logger logger = LoggerFactory.getLogger(PautaValidadorImpl.class);

    private final PautaService pautaService;

    @Autowired
    public PautaValidadorImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Override
    public void validar(Long idPauta) {
        logger.info("validando pauta nº: "+ idPauta);
        Pauta pauta = pautaService.buscarPorId(idPauta);
        if (pauta.estahFechada()) {
            throw new SessaoFechadaException(SESSAO_FECHADA_EXCEPTION);
        }
    }

}
