package com.example.demo.web.rest.dto;

public class SessaoDTO {

    private Long idPauta;
    private Integer minutos;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public Integer getMinutos() {
        return minutos;
    }

    public void setMinutos(Integer minutos) {
        this.minutos = minutos;
    }
}
