package com.example.demo.service.validator.impl;


import com.example.demo.config.CpfConfig;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.web.rest.dto.CpfDTO;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.example.demo.shared.Constantes.ABLE_TO_VOTE;
import static com.example.demo.shared.Constantes.CPF_INVALIDO_EXCEPTION;
import static java.lang.String.format;

@Component
public class CpfValidadorImpl implements CpfValidador {

    private final CpfConfig cpfConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public CpfValidadorImpl(RestTemplate restTemplate, CpfConfig cpfConfig) {
        this.restTemplate = restTemplate;
        this.cpfConfig = cpfConfig;
    }

    @Override
    public boolean ehValido(String cpf) {
        CpfDTO resposta = buscarCpf(cpf);

        return ehApto(resposta);
    }

    private CpfDTO buscarCpf(String cpf) {
        String uri = obterUri(cpf);
        try {
            return restTemplate.getForObject(uri, CpfDTO.class);
        } catch (HttpClientErrorException e) {
            throw new CpfInvalidoException(CPF_INVALIDO_EXCEPTION);
        }
    }

    private String obterUri(String cpf) {
        return format(this.cpfConfig.getUrl(), cpf);
    }

    private boolean ehApto(CpfDTO resposta) {
        return resposta.getStatus().equals(ABLE_TO_VOTE);
    }
}
