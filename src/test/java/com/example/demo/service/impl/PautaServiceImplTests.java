package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.repository.PautaRepository;
import com.example.demo.service.PautaService;
import com.example.demo.web.rest.dto.SessaoDTO;
import com.example.demo.web.rest.exception.PautaNaoEncontradaException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoComMinuto;
import static com.example.demo.builders.pauta.PautaBuilder.umaListaDePautas;
import static com.example.demo.builders.pauta.PautaBuilder.umaPautaFechada;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class PautaServiceImplTests {

    private Pauta pauta;
    private List<Pauta> pautas;
    private SessaoDTO sessaoDTO;
    private PautaService pautaService;
    private PautaRepository pautaRepository;

    @BeforeEach
    public void setUp() {
        pauta = umaPautaFechada();
        sessaoDTO = umaSessaoComMinuto();
        pautas = umaListaDePautas();

        pautaRepository = mock(PautaRepository.class);
        this.pautaService = new PautaServiceImpl(pautaRepository);

        Mockito.when(pautaRepository.save(any(Pauta.class))).thenReturn(pauta);
        Mockito.when(pautaRepository.findAllByStatus(any(String.class))).thenReturn(pautas);
        Mockito.when(pautaRepository.findById(any(Long.class))).thenReturn(Optional.of(pauta));
    }

    @Test
    @DisplayName("deve cadastrar uma sessao")
    public void deveCadastrarUmaSessao() {
        Pauta esperada = pautaService.cadastrar(pauta);

        Assertions.assertEquals(esperada.getId(), pauta.getId());
        Assertions.assertEquals(esperada.getStatus(), pauta.getStatus());
        Assertions.assertEquals(esperada.getTitulo(), pauta.getTitulo());
        Assertions.assertEquals(esperada.getTempoLimite(), pauta.getTempoLimite());
    }

    @Test
    @DisplayName("deve abrir sessao em uma pauta")
    public void deveAbrirSessaoEmUmaPauta() {
        Pauta esperada = pautaService.abrirVotacao(sessaoDTO);

        Assertions.assertEquals(esperada.getId(), pauta.getId());
        Assertions.assertEquals(esperada.getStatus(), pauta.getStatus());
        Assertions.assertEquals(esperada.getTitulo(), pauta.getTitulo());
        Assertions.assertEquals(esperada.getTempoLimite(), pauta.getTempoLimite());
    }

    @Test
    @DisplayName("deve buscar pauta por id")
    public void deveBuscarPautaPorId() {
        Pauta esperada = pautaService.buscarPorId(1L);

        Assertions.assertEquals(esperada.getId(), pauta.getId());
        Assertions.assertEquals(esperada.getStatus(), pauta.getStatus());
        Assertions.assertEquals(esperada.getTitulo(), pauta.getTitulo());
        Assertions.assertEquals(esperada.getTempoLimite(), pauta.getTempoLimite());
    }

    @Test
    @DisplayName("deve lançar Pauta Nao Encontrada Exception")
    public void deveLancarPautaNaoEncontradaException() {
        Mockito.when(pautaRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(PautaNaoEncontradaException.class, () -> {
            pautaService.buscarPorId(1L);
        });
    }

    @Test
    @DisplayName("deve retornar pautas abertas")
    public void deveRetornarPautasAbertas() {
        List<Pauta> pautasEsperadas = pautaService.consultarPautasAbertas();

        Assertions.assertEquals(pautasEsperadas, pautas);
    }

    @Test
    @DisplayName("deve atualizar uma pauta")
    public void deveAtualizarUmaPauta() {
        Pauta esperada = pautaService.atualizarPauta(this.pauta);

        Assertions.assertEquals(esperada.getId(), pauta.getId());
        Assertions.assertEquals(esperada.getStatus(), pauta.getStatus());
        Assertions.assertEquals(esperada.getTitulo(), pauta.getTitulo());
        Assertions.assertEquals(esperada.getTempoLimite(), pauta.getTempoLimite());
    }
}
