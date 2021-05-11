package com.example.demo.service.validator.impl;


import com.example.demo.config.CpfConfig;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.web.rest.dto.CpfDTO;
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
        CpfDTO resposta = buscarCpf(cpf);

        return ehApto(resposta);
    }

    private CpfDTO buscarCpf(String cpf) {
        String uri = format(this.cpfConfig.getUrl(), cpf);

        CpfDTO cpfDTO;
        try {
            cpfDTO = restTemplate.getForObject(uri, CpfDTO.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("CPF inválido");
        }
        return cpfDTO;
    }

    private boolean ehApto(CpfDTO resposta) {
        return resposta.getStatus().equals("ABLE_TO_VOTE");
    }
}
