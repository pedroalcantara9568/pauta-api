package com.example.demo.web.rest;

import com.example.demo.domain.voto.Voto;
import com.example.demo.service.VotoService;
import com.example.demo.web.rest.dto.VotoDTO;
import com.example.demo.web.rest.mapper.VotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votos")
public class VotoResource {

    private final VotoService votoService;

    @Autowired
    public VotoResource(VotoService votoService) {
        this.votoService = votoService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody VotoDTO votoDTO) {
        Voto votoCadastrado = votoService.cadastrar(VotoMapper.toEntity(votoDTO));
        return new ResponseEntity<>(VotoMapper.toDto(votoCadastrado), HttpStatus.CREATED);
    }
}
