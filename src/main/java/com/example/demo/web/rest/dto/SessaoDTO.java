package com.example.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SessaoDTO {

    @JsonProperty("id_pauta")
    private Long idPauta;

    @JsonProperty("minutos")
    private Integer minutos;
}
