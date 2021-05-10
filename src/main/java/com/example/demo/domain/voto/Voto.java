package com.example.demo.domain.voto;

import javax.persistence.*;

@IdClass(VotoPK.class)
@Entity(name = "VOTO")
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"CPF", "VOTO"})})
public class Voto {

    @Id
    @Column(name = "ID_PAUTA")
    private Long idPauta;

    @Id
    @Column(name = "CPF")
    private String cpf;

    @Column(name = "VOTO")
    private String voto;

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

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Voto voto1 = (Voto) o;

        if (!idPauta.equals(voto1.idPauta)) return false;
        if (!cpf.equals(voto1.cpf)) return false;
        return voto.equals(voto1.voto);
    }

    @Override
    public int hashCode() {
        int result = idPauta.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + voto.hashCode();
        return result;
    }
}
