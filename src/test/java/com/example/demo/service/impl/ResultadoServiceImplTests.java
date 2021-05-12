package com.example.demo.service.impl;

import com.example.demo.service.PautaService;
import com.example.demo.service.ResultadoService;
import com.example.demo.web.rest.dto.ResultadoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import static com.example.demo.builders.pauta.PautaBuilder.*;
import static com.example.demo.shared.Constantes.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class ResultadoServiceImplTests {


    @Autowired
    private ResultadoService resultadoService;

    @MockBean
    private PautaService pautaService;

    @BeforeEach
    public void setUp() {
        pautaService = mock(PautaServiceImpl.class);
        resultadoService = new ResultadoServiceImpl(pautaService);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Sim")
    public void resultadoDaPautaDeveSerSim() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosSim());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), SIM);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Não")
    public void resultadoDaPautaDeveSerNao() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaComMaisVotosNao());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), NAO);
    }

    @Test
    @DisplayName("resultado da pauta deve ser Empate")
    public void resultadoDaPautaDeveSerEmpate() {
        Mockito.when(pautaService.buscarPorId(any(Long.class))).thenReturn(umaPautaEmpatada());

        ResultadoDTO resultadoDTO = resultadoService.obterResultado(1L);
        Assertions.assertEquals(resultadoDTO.getResultado(), EMPATE);
    }
}
