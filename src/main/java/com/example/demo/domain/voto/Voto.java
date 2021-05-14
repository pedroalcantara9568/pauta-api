package com.example.demo.domain.voto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(VotoPK.class)
@Entity(name = "VOTO")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"ID_COOPERADO", "ID_PAUTA"})})
public class Voto {

    @Id
    @Column(name = "ID_PAUTA")
    private Long idPauta;

    @Id
    @Column(name = "ID_COOPERADO")
    private Long idCooperado;

    @Column(name = "CPF")
    private String cpf;

    @Column(name = "VOTO")
    private String voto;

    public Long getIdCooperado() {
        return idCooperado;
    }

    public Long getIdPauta() {
        return idPauta;
    }

    public String getCpf() {
        return cpf;
    }

    public String getVoto() {
        return voto;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "idPauta=" + idPauta +
                ", cpf='" + cpf + '\'' +
                ", voto='" + voto + '\'' +
                '}';
    }
}
