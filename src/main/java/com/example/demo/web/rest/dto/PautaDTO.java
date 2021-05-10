package com.example.demo.web.rest.dto;

import com.example.demo.voto.Voto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PautaDTO implements Serializable {

    private Long id;
    private String titulo;
    Set<Voto> votos;
    private String status;
    private LocalDateTime tempoLimite;

}
