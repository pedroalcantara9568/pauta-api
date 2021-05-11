package com.example.demo.web.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SessaoDTO {

    private Long idPauta;
    private Integer minutos;
}
