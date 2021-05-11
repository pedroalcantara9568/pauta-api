package com.example.demo.web.rest.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PautaDTO implements Serializable {

    @JsonProperty("id_pauta")
    private Long id;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("status")
    private String status;

    @JsonProperty("datahora_limite")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime tempoLimite;
}
