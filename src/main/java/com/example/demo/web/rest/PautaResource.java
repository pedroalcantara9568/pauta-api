package com.example.demo.web.rest;

import com.example.demo.domain.Pauta;
import com.example.demo.service.PautaService;
import com.example.demo.web.rest.dto.PautaDTO;
import com.example.demo.web.rest.dto.SessaoDTO;
import com.example.demo.web.rest.mapper.PautaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.demo.web.rest.mapper.PautaMapper.toDto;

@RestController
@RequestMapping("/pautas")
public class PautaResource {

    private final PautaService pautaService;

    @Autowired
    public PautaResource(PautaService pautaService) {
        this.pautaService = pautaService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrar(@RequestBody PautaDTO pautaDTO) {
        Pauta pautaCadastrada = pautaService.cadastrar(PautaMapper.toEntity(pautaDTO));
        return new ResponseEntity<>(toDto(pautaCadastrada), HttpStatus.CREATED);
    }

    @PostMapping("/abrir")
    public ResponseEntity<Object> abrirVotacao(@RequestBody SessaoDTO sessaoDTO) {
        Pauta pautaAberta = pautaService.abrirVotacao(sessaoDTO);
        return new ResponseEntity<>(toDto(pautaAberta), HttpStatus.ACCEPTED);
    }
}
