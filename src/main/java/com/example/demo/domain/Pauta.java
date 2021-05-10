package com.example.demo.domain;

import com.example.demo.domain.voto.Voto;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

import static javax.persistence.GenerationType.AUTO;

@Entity(name = "PAUTA")
public class Pauta {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "ID_PAUTA")
    private Long id;

    @Column(name = "TITULO")
    private String titulo;

    @OneToMany
    @LazyCollection(value = LazyCollectionOption.FALSE)
    @JoinColumn(name = "ID_PAUTA", referencedColumnName = "ID_PAUTA")
    Set<Voto> votos;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DTH_LIMITE")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime tempoLimite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTempoLimite() {
        return tempoLimite;
    }

    public void setTempoLimite(LocalDateTime tempoLimite) {
        this.tempoLimite = tempoLimite;
    }
}