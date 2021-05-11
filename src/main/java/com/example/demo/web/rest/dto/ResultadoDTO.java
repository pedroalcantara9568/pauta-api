package com.example.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultadoDTO {

    @JsonProperty("id_pauta")
    private Long seqPauta;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("status")
    private String status;

    @JsonProperty("quantidade_sim")
    private Integer quantidadeSim;

    @JsonProperty("quantidade_nao")
    private Integer quantidadeNao;

    @JsonProperty("resultado")
    private String resultado;
}
