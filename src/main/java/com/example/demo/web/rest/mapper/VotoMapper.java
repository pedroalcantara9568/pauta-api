package com.example.demo.web.rest.mapper;

import com.example.demo.domain.voto.Voto;
import com.example.demo.web.rest.dto.VotoDTO;

public class VotoMapper {
    public static Voto toEntity(VotoDTO votoDTO) {
        return Voto.builder()
                .cpf(votoDTO.getCpf())
                .idPauta(votoDTO.getIdPauta())
                .voto(votoDTO.getVoto())
                .build();
    }

    public static VotoDTO toDto(Voto voto) {
        return VotoDTO.builder()
                .cpf(voto.getCpf())
                .idPauta(voto.getIdPauta())
                .voto(voto.getVoto())
                .build();
    }
}
