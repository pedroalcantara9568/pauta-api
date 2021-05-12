package com.example.demo.builders.pauta;

import com.example.demo.domain.Pauta;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.shared.Constantes.ABERTA;
import static com.example.demo.shared.Constantes.FECHADA;

public class PautaBuilder {
    public static Pauta umaPautaFechada() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .tempoLimite(LocalDateTime.now())
                .status(FECHADA).build();
    }

    public static Pauta umaPautaSemStatus() {
        return Pauta.builder()
                .titulo("coxinha > all")
                .build();
    }

    public static Pauta umaPautaAberta() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .status(ABERTA)
                .tempoLimite(LocalDateTime.now().plusMinutes(2))
                .build();
    }

    public static List<Pauta> umaListaDePautas() {
        return List.of(umaPautaAberta());
    }
}
