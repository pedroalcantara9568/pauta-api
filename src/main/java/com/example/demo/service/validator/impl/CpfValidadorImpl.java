package com.example.demo.service.validator.impl;


import com.example.demo.config.CpfConfig;
import com.example.demo.service.impl.PautaServiceImpl;
import com.example.demo.service.validator.CpfValidador;
import com.example.demo.web.rest.dto.CpfDTO;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static com.example.demo.shared.Constantes.ABLE_TO_VOTE;
import static com.example.demo.shared.Constantes.CPF_INVALIDO_EXCEPTION;
import static java.lang.String.format;

@Component
public class CpfValidadorImpl implements CpfValidador {


    private static final Logger logger = LoggerFactory.getLogger(CpfValidadorImpl.class);

    private final CpfConfig cpfConfig;
    private final RestTemplate restTemplate;

    @Autowired
    public CpfValidadorImpl(RestTemplate restTemplate, CpfConfig cpfConfig) {
        this.restTemplate = restTemplate;
        this.cpfConfig = cpfConfig;
    }

    @Override
    public void validar(String cpf) {
        logger.info("validando CPF: " +cpf);
        CpfDTO resposta = buscarCpf(cpf);

        ehApto(resposta);
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

    private void ehApto(CpfDTO resposta) {
        if (!resposta.getStatus().equals(ABLE_TO_VOTE)) {
            throw new CpfInvalidoException(CPF_INVALIDO_EXCEPTION);
        }
    }
}
