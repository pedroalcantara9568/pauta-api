package com.example.demo.service;

import com.example.demo.web.rest.dto.ResultadoDTO;
import org.springframework.stereotype.Service;

@Service
public interface ResultadoService {
    ResultadoDTO obterResultado(Long id);
}
