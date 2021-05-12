package com.example.demo.service.validator;

import com.example.demo.domain.voto.Voto;
import com.example.demo.service.VotoService;
import com.example.demo.service.impl.VotoServiceImpl;
import com.example.demo.service.validator.impl.VotoValidadorImpl;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static com.example.demo.builders.voto.VotoBuilder.umVoto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

public class VotoValidadorImplTests {

    @Autowired
    private VotoValidador votoValidador;

    @MockBean
    private CpfValidador cpfValidador;

    @MockBean
    private VotoService votoService;

    @BeforeEach
    public void setUp() {
        cpfValidador = mock(CpfValidador.class);
        votoService = mock(VotoServiceImpl.class);
        this.votoValidador = new VotoValidadorImpl(votoService, cpfValidador);
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar CPF")
    public void naoDeveLancarExcecaoAoValidar(){
        Mockito.when(this.votoService.buscarPorId(any(Voto.class))).thenReturn(Optional.empty());

        votoValidador.validar(umVoto());
    }

    @Test
    @DisplayName("deve lançar exceção ao validar voto duplicado")
    public void deveLancarExcecaoAoValidarVotoDuplicado(){
        Mockito.when(this.votoService.buscarPorId(any(Voto.class))).thenReturn(Optional.of(umVoto()));

        Assertions.assertThrows(VotoDuplicadoException.class, ()->{
            votoValidador.validar(umVoto());
        });
    }
}
