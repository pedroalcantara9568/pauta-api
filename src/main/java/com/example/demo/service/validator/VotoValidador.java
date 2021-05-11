package com.example.demo.service.validator;

import com.example.demo.domain.voto.Voto;
import org.springframework.stereotype.Service;

@Service
public interface VotoValidador {
    void validar(Voto voto);
}
