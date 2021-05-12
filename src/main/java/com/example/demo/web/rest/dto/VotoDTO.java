package com.example.demo.web.rest.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VotoDTO implements Serializable {

    @JsonProperty("id_pauta")
    private Long idPauta;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("voto")
    private String voto;
}
