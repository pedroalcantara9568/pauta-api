package com.example.demo.service.validator;

import com.example.demo.config.CpfConfig;
import com.example.demo.service.validator.impl.CpfValidadorImpl;
import com.example.demo.web.rest.dto.CpfDTO;
import com.example.demo.web.rest.exception.CpfInvalidoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static com.example.demo.builders.CpfDTOBuilder.umCpfDTOInvalido;
import static com.example.demo.builders.CpfDTOBuilder.umCpfDTOValido;
import static java.lang.String.format;
import static org.mockito.Mockito.mock;

public class CpfValidatorImplTests {

    @Autowired
    private CpfValidador cpfValidador;

    @Mock
    private RestTemplate restTemplate;

    private CpfConfig cpfConfig;

    String cpf;

    @BeforeEach
    public void setUp() {
        cpf = "10338927425";
        cpfConfig = new CpfConfig();
        cpfConfig.setUrl("https://user-info.herokuapp.com/users/%s");

        restTemplate = mock(RestTemplate.class);
        cpfValidador = new CpfValidadorImpl(restTemplate, cpfConfig);
    }

    @Test
    @DisplayName("deve lançar Exceção ao validar CPF Inválido")
    public void cpfDeveSerInvalido() {
        Mockito.when(this.restTemplate.getForObject(format(cpfConfig.getUrl(), cpf), CpfDTO.class)).thenReturn(umCpfDTOInvalido());

        Assertions.assertThrows(CpfInvalidoException.class, ()->{
           cpfValidador.validar(cpf);
        });
    }

    @Test
    @DisplayName("cpf deve ser válido")
    public void cpfDeveSerValido() {
        Mockito.when(this.restTemplate.getForObject(format(cpfConfig.getUrl(), cpf), CpfDTO.class)).thenReturn(umCpfDTOValido());
        cpfValidador.validar(cpf);
    }

}
