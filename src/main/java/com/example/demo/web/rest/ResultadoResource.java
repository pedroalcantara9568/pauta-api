package com.example.demo.web.rest;

import com.example.demo.service.ResultadoService;
import com.example.demo.web.rest.dto.ResultadoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resultados")
public class ResultadoResource {

    private final ResultadoService resultadoService;

    @Autowired
    public ResultadoResource(ResultadoService resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping(value = "/{id}", headers = "Api-Version=1")
    public ResponseEntity<Object> obterResultado(@PathVariable Long id) {
        ResultadoDTO resultadoDTO = resultadoService.obterResultado(id);
        return new ResponseEntity<>(resultadoDTO, HttpStatus.OK);
    }
}
