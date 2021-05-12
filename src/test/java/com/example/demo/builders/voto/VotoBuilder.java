package com.example.demo.builders.voto;

import com.example.demo.domain.voto.Voto;

import static com.example.demo.shared.Constantes.SIM;

public class VotoBuilder {

    public static Voto umVoto() {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(SIM)
                .build();
    }

    public static Voto umVoto(String voto) {
        return Voto.builder()
                .cpf("10338927425")
                .idPauta(1L)
                .voto(voto)
                .build();
    }
}
