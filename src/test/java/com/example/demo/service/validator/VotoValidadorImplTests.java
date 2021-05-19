package com.example.demo.service.validator;

import com.example.demo.domain.voto.Voto;
import com.example.demo.domain.voto.VotoPK;
import com.example.demo.repository.VotoRepository;
import com.example.demo.service.VotoService;
import com.example.demo.service.impl.VotoServiceImpl;
import com.example.demo.service.validator.impl.VotoValidadorImpl;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import com.example.demo.web.rest.exception.VotoInvalidoException;
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
    private VotoRepository votoRepository;

    @BeforeEach
    public void setUp() {
        cpfValidador = mock(CpfValidador.class);
        votoRepository = mock(VotoRepository.class);
        this.votoValidador = new VotoValidadorImpl(votoRepository, cpfValidador);
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar CPF")
    public void naoDeveLancarExcecaoAoValidar(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(umVoto());
    }

    @Test
    @DisplayName("deve lançar exceção ao validar voto duplicado")
    public void deveLancarExcecaoAoValidarVotoDuplicado(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.of(umVoto()));

        Assertions.assertThrows(VotoDuplicadoException.class, ()->{
            votoValidador.validar(umVoto());
        });
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar voto Sim válido")
    public void naoDeveLancarExcecaoAoValidarVotoSimValido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(umVoto("Sim"));
    }

    @Test
    @DisplayName("deve lançar exceção ao validar voto Sim inváldio")
    public void deveLancarExcecaoAoValidarVotoSimInvalido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(VotoInvalidoException.class, ()->{
            votoValidador.validar(umVoto("sim"));
        });
    }

    @Test
    @DisplayName("não deve lançar exceção ao validar voto Não válido")
    public void naoDeveLancarExcecaoAoValidarVotoNaoValido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        votoValidador.validar(umVoto("Não"));
    }


    @Test
    @DisplayName("deve lançar exceção ao validar voto inváldio")
    public void deveLancarExcecaoAoValidarVotoInvalido(){
        Mockito.when(this.votoRepository.findById(any(VotoPK.class))).thenReturn(Optional.empty());

        Assertions.assertThrows(VotoInvalidoException.class, ()->{
            votoValidador.validar(umVoto("sim"));
        });
    }



}
