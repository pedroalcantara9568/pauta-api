package com.example.demo.web.rest.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class VotoDTO implements Serializable {

    private Long idPauta;
    private String cpf;
    private String voto;
}
