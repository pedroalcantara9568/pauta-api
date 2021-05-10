package com.example.demo.service;

import com.example.demo.domain.Pauta;
import org.springframework.stereotype.Service;

@Service
public interface PautaService {
    Pauta cadastrar(Pauta toEntity);
}
