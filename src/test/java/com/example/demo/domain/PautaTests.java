package com.example.demo.domain;

import com.example.demo.builders.SessaoDTOBuilder;
import com.example.demo.web.rest.dto.SessaoDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoComMinuto;
import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoSemMinuto;
import static com.example.demo.builders.pauta.PautaBuilder.*;
import static com.example.demo.shared.Constantes.ABERTA;
import static com.example.demo.shared.Constantes.FECHADA;


public class PautaTests {


    @Test
    @DisplayName("deve abrir Sessão com tempo informado")
    public void deveAbrirVotacao() {
        Pauta pauta = umaPautaFechada();
        SessaoDTO sessao = umaSessaoComMinuto(15);

        LocalDateTime dataHoraLimite = pauta.abrirVotacao(sessao);

        Assertions.assertEquals(pauta.getStatus(), ABERTA);
        Assertions.assertEquals(pauta.getTempoLimite(), dataHoraLimite);
        Assertions.assertEquals(pauta.isEnviadoKafka(), false);
    }

    @Test
    @DisplayName("deve abrir Sessão com tempo padrão")
    public void deveAbrirVotacaoComTempoPadrão() {
        Pauta pauta = umaPautaFechada();
        SessaoDTO sessao = SessaoDTOBuilder.umaSessaoSemMinuto();

        LocalDateTime dataHoraLimite = pauta.abrirVotacao(sessao);

        Assertions.assertEquals(pauta.getStatus(), ABERTA);
        Assertions.assertEquals(pauta.getTempoLimite(), dataHoraLimite);
        Assertions.assertEquals(pauta.isEnviadoKafka(), false);
    }

    @Test
    @DisplayName("deve estar fechada e nao enviada")
    public void deveEstarFechadaIhNaoEnviada() {
        Pauta pauta = umaPautaFechadaIhNaoEnviada();

        Assertions.assertTrue(pauta.estahFechadaIhNaoFoiEnviada());
    }

    @Test
    @DisplayName("Deve abrir Sessão com pauta sem status")
    public void deveAbrirVotacaoComPautaSemStatus() {
        Pauta pauta = umaPautaSemStatus();
        pauta.obterStatusFechadaCasoNulo(pauta);

        Assertions.assertEquals(pauta.getStatus(), FECHADA);
    }

    @Test
    @DisplayName("uma Pauta deve estar fechada")
    public void umaSessaoDeveEstarFechada() {
        Pauta pauta = umaPautaFechada();

        Assertions.assertTrue(pauta.estahFechada());
    }

    @Test
    @DisplayName("uma Pauta deve estar fechada por tempo")
    public void umaSessaoDeveEstarFechadaPorTempo() {
        Pauta pauta = umaPautaFechadaPorTempo();

        Assertions.assertTrue(pauta.estahFechada());
    }

    @Test
    @DisplayName("uma Pauta não Deve estar fechada")
    public void umaSessaoNaoDeveEstarFechada() {
        Pauta pauta = umaPautaAberta();

        Assertions.assertFalse(pauta.estahFechada());
    }
}
