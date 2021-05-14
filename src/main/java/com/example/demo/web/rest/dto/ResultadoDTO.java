package com.example.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoDTO implements Serializable {

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

    @Override
    public String toString() {
        return "ResultadoDTO{" +
                "seqPauta=" + seqPauta +
                ", titulo='" + titulo + '\'' +
                ", status='" + status + '\'' +
                ", quantidadeSim=" + quantidadeSim +
                ", quantidadeNao=" + quantidadeNao +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
