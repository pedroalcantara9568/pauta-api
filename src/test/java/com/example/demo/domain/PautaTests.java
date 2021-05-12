package com.example.demo.domain;

import com.example.demo.web.rest.dto.SessaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoComUmMinuto;
import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoSemMinuto;
import static com.example.demo.builders.pauta.PautaBuilder.*;
import static com.example.demo.shared.Constantes.ABERTA;
import static com.example.demo.shared.Constantes.FECHADA;


public class PautaTests {


    @Test
    @DisplayName("deve abrir Sessão com tempo informado")
    public void deveAbrirVotacao() {
        Pauta pauta = umaPautaFechada();
        SessaoDTO sessao = umaSessaoComUmMinuto();

        pauta.abrirVotacao(sessao);

        Assertions.assertEquals(pauta.getStatus(), ABERTA);
    }

    @Test
    @DisplayName("deve abrir Sessão com tempo padrão")
    public void deveAbrirVotacaoComTempoPadrao() {
        Pauta pauta = umaPautaFechada();
        SessaoDTO sessao = umaSessaoSemMinuto();
        pauta.abrirVotacao(sessao);

        Assertions.assertEquals(pauta.getStatus(), ABERTA);
    }

    @Test
    @DisplayName("Deve abrir Sessão com pauta sem status")
    public void deveAbrirVotacaoComPautaSemStatus() {
        Pauta pauta = umaPautaSemStatus();
        pauta.obterStatusFechadaCasoNulo(pauta);

        Assertions.assertEquals(pauta.getStatus(), FECHADA);
    }

    @Test
    @DisplayName("uma Sessão deve estar fechada")
    public void umaSessaoDeveEstarFechada() {
        Pauta pauta = umaPautaFechada();

        Assertions.assertTrue(pauta.estahFechada());
    }

    @Test
    @DisplayName("uma Sessão não Deve estar fechada")
    public void umaSessaoNaoDeveEstarFechada() {
        Pauta pauta = umaPautaAberta();

        Assertions.assertFalse(pauta.estahFechada());
    }
}
