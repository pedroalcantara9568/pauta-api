package com.example.demo.builders.pauta;

import com.example.demo.domain.Pauta;

import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.builders.voto.VotoBuilder.umVoto;
import static com.example.demo.shared.Constantes.*;
import static java.util.Set.of;

public class PautaBuilder {
    public static Pauta umaPautaFechada() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .tempoLimite(LocalDateTime.now())
                .status(FECHADA).build();
    }

    public static Pauta umaPautaFechadaIhNaoEnviada() {
        return Pauta.builder()
                .enviadoKafka(false)
                .status(FECHADA)
                .build();
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

    public static Pauta umaPautaComMaisVotosSim() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .votos(of(umVoto(SIM), umVoto(SIM), umVoto(SIM), umVoto(NAO), umVoto(NAO)))
                .tempoLimite(LocalDateTime.now().minusMinutes(1))
                .status(FECHADA)
                .build();
    }

    public static Pauta umaPautaEmpatada() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .votos(of(umVoto(SIM), umVoto(SIM), umVoto(SIM), umVoto(NAO), umVoto(NAO), umVoto(NAO)))
                .tempoLimite(LocalDateTime.now().minusMinutes(1))
                .status(FECHADA)
                .build();
    }

    public static Pauta umaPautaComMaisVotosNao() {
        return Pauta.builder()
                .id(1L)
                .titulo("coxinha > all")
                .votos(of(umVoto(SIM), umVoto(SIM), umVoto(NAO), umVoto(NAO), umVoto(NAO)))
                .tempoLimite(LocalDateTime.now().minusMinutes(1))
                .status(FECHADA)
                .build();
    }

}
