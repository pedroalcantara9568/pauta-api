package com.example.demo.service.impl;

import com.example.demo.domain.Pauta;
import com.example.demo.domain.voto.Voto;
import com.example.demo.service.PautaService;
import com.example.demo.service.ResultadoService;
import com.example.demo.web.rest.dto.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.demo.shared.Constantes.*;

@Component
public class ResultadoServiceImpl implements ResultadoService {

    private final PautaService pautaService;

    @Autowired
    public ResultadoServiceImpl(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @Override
    public ResultadoDTO obterResultado(Long id) {
        Pauta pauta = pautaService.buscarPorId(id);
        return construirResultado(pauta);
    }

    private ResultadoDTO construirResultado(Pauta pauta) {
        Integer quantidadeSim = obterQuantidadePorOpcao(pauta.getVotos(), SIM);
        Integer quantidadeNao = obterQuantidadePorOpcao(pauta.getVotos(), NAO);

        return ResultadoDTO.builder()
                .seqPauta(pauta.getId())
                .titulo(pauta.getTitulo())
                .quantidadeNao(quantidadeNao)
                .quantidadeSim(quantidadeSim)
                .status(pauta.getStatus())
                .resultado(calcularVotos(quantidadeSim, quantidadeNao))
                .build();
    }

    private String calcularVotos(Integer quantidadeSim, Integer quantidadeNao) {
        if (quantidadeNao.equals(quantidadeSim)) {
            return EMPATE;
        } else if (quantidadeNao > quantidadeSim) {
            return NAO;
        } else {
            return SIM;
        }
    }

    private Integer obterQuantidadePorOpcao(Set<Voto> votos, String opcao) {
        List<Voto> votosFiltrados = votos.stream().filter(voto -> opcao.equals(voto.getVoto())).collect(Collectors.toList());
        return votosFiltrados.size();
    }
}
