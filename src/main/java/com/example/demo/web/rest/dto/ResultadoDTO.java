package com.example.demo.web.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultadoDTO {

    private Long seqPauta;

    private String titulo;

    private Integer quantidadeSim;

    private Integer quantidadeNao;

    private String status;

    private String resultado;
}