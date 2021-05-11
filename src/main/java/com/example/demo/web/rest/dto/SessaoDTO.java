package com.example.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessaoDTO {

    @JsonProperty("id_pauta")
    private Long idPauta;

    @JsonProperty("minutos")
    private Integer minutos;
}
