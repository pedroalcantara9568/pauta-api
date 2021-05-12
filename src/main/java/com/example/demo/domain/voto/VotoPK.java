package com.example.demo.domain.voto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Builder
public class VotoPK implements Serializable {

    private Long idPauta;
    private String cpf;
}
