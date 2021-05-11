package com.example.demo.repository;

import com.example.demo.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PautaRepository extends JpaRepository<Pauta, Long> {
    List<Pauta> findAllByStatus(String aberta);
}
