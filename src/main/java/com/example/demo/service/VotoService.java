package com.example.demo.service;

import com.example.demo.domain.voto.Voto;
import org.springframework.stereotype.Service;

@Service
public interface VotoService {
    Voto cadastrar(Voto voto);
}
