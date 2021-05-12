package com.example.demo.builders.voto;

import com.example.demo.domain.voto.Voto;
import com.example.demo.web.rest.dto.VotoDTO;

import static com.example.demo.shared.Constantes.SIM;

public class VotoDTOBuilder {

    public static VotoDTO umVotoDTO() {
        return VotoDTO.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(SIM)
                .build();
    }
}
