package com.example.demo.service.validator.impl;


import com.example.demo.config.CpfConfig;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.web.rest.dto.StatusCpf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;

@Component
public class CpfValidadorImpl implements CpfValidador {

    private final RestTemplate restTemplate;
    private final CpfConfig cpfConfig;

    @Autowired
    public CpfValidadorImpl(RestTemplate restTemplate, CpfConfig cpfConfig) {
        this.restTemplate = restTemplate;
        this.cpfConfig = cpfConfig;
    }

    @Override
    public boolean ehValido(String cpf) {
        StatusCpf resposta = buscarCpf(cpf);

        return ehApto(resposta);
    }

    private StatusCpf buscarCpf(String cpf) {
        String uri = format(this.cpfConfig.getUrl(), cpf);

        StatusCpf statusCpf;
        try {
            statusCpf = restTemplate.getForObject(uri, StatusCpf.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("CPF inválido");
        }
        return statusCpf;
    }

    private boolean ehApto(StatusCpf resposta) {
        return resposta.getStatus().equals("ABLE_TO_VOTE");
    }
}
