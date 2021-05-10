package com.example.demo.repository;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, VotoPK> {
}
