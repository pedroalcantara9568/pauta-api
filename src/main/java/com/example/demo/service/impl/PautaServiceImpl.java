package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.PautaService;
import com.example.demo.web.rest.dto.SessaoDTO;
import com.example.demo.web.rest.exception.PautaNaoEncontradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.demo.shared.Constantes.ABERTA;
import static com.example.demo.shared.Constantes.PAUTA_NAO_ENCONTRADA_EXCEPTION;
import static com.example.demo.shared.JsonUtil.toJson;

@Component
public class PautaServiceImpl implements PautaService {

    private static final Logger logger = LoggerFactory.getLogger(PautaServiceImpl.class);

    private final PautaRepository pautaRepository;

    @Autowired
    public PautaServiceImpl(PautaRepository pautaRepository) {
        this.pautaRepository = pautaRepository;
    }

    @Override
    public Pauta cadastrar(Pauta pauta) {
        pauta.obterStatusFechadaCasoNulo(pauta);
        logger.info("salvando pauta: " + pauta);
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta abrirVotacao(SessaoDTO sessaoDTO) {
        logger.info("abrindo nova Sessao: " + sessaoDTO);
        Pauta pauta = buscarPorId(sessaoDTO.getIdPauta());
        pauta.abrirVotacao(sessaoDTO);

        logger.info("salvando pauta: " + pauta);
        return pautaRepository.save(pauta);
    }

    @Override
    public Pauta buscarPorId(Long id) {
        logger.info("abrindo nova Pauta por id: " + id);
        return pautaRepository.findById(id).orElseThrow(() -> {
            throw new PautaNaoEncontradaException(PAUTA_NAO_ENCONTRADA_EXCEPTION);
        });
    }

    @Override
    public List<Pauta> consultarPautasAbertas() {
        logger.info("Consultando paltas com status aberto");
        return pautaRepository.findAllByStatus(ABERTA);
    }

    @Override
    public Pauta atualizarPauta(Pauta pauta) {

        logger.info("atualizando pauta: " + pauta);
        return this.pautaRepository.save(pauta);
    }
}
