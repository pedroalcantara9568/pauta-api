package com.example.demo.service.validator;

import org.springframework.stereotype.Service;

@Service
public interface CpfValidador {

    boolean ehValido(String cpf);
}
