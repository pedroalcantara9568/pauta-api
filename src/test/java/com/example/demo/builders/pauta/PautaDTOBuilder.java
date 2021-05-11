package com.example.demo.builders.pauta;

import com.example.demo.domain.Pauta;
import com.example.demo.web.rest.dto.PautaDTO;

public class PautaDTOBuilder {

    public static PautaDTO umaPautaDTO(){
        return PautaDTO.builder()
                .id(1L)
                .titulo("coxinha > all")
                .build();
    }
}
