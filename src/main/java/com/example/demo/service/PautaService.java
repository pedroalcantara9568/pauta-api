package com.example.demo.service;

import com.example.demo.domain.Pauta;
import com.example.demo.web.rest.dto.SessaoDTO;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    Pauta cadastrar(Pauta toEntity);

    Pauta abrirVotacao(SessaoDTO sessaoDTO);
}
