package com.example.demo.voto;

import java.io.Serializable;

public class VotoPK implements Serializable {

    private Long idPauta;

    private String cpf;

    public Long getIdPauta() {
        return idPauta;
    }

    public void setIdPauta(Long idPauta) {
        this.idPauta = idPauta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
