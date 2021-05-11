package com.example.demo.service.validator;

import com.example.demo.domain.Pauta;
import org.springframework.stereotype.Service;

@Service
public interface PautaValidador {
    void validar(Long idPauta);
}
