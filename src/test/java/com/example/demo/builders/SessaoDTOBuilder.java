package com.example.demo.builders;

import com.example.demo.domain.Pauta;
import com.example.demo.web.rest.dto.SessaoDTO;

import static com.example.demo.shared.Constantes.FECHADA;

public class SessaoDTOBuilder {

    public static SessaoDTO umaSessaoComUmMinuto(){
        return SessaoDTO.builder()
                .idPauta(1L)
                .minutos(3)
                .build();
    }

    public static SessaoDTO umaSessaoSemMinuto(){
        return SessaoDTO.builder().build();
    }
}
