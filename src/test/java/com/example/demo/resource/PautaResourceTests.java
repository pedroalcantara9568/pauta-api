package com.example.demo.resource;

import com.example.demo.domain.Pauta;
import com.example.demo.service.PautaService;
import com.example.demo.web.rest.PautaResource;
import com.example.demo.web.rest.dto.PautaDTO;
import com.example.demo.web.rest.dto.SessaoDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import static com.example.demo.builders.SessaoDTOBuilder.umaSessaoComUmMinuto;
import static com.example.demo.builders.pauta.PautaBuilder.umaPautaFechada;
import static com.example.demo.builders.pauta.PautaDTOBuilder.umaPautaDTO;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.ArgumentMatchers.any;

@WebMvcTest(controllers = PautaResource.class)
public class PautaResourceTests {

    @Autowired
    private PautaResource pautaResource;

    @MockBean
    private PautaService pautaService;

    PautaDTO pautaDTO;

    private Pauta pauta;

    private SessaoDTO sessaoDTO;

    @BeforeEach
    public void setUp() {
        pautaDTO = umaPautaDTO();
        sessaoDTO = umaSessaoComUmMinuto();
        pauta = umaPautaFechada();
        standaloneSetup(this.pautaResource);
    }

    @Test
    @DisplayName("deve cadastrar pauta com sucesso")
    public void deveCadastrarPautaComSucesso() {
        Mockito.when(this.pautaService.cadastrar(any(Pauta.class))).thenReturn(pauta);

        given().contentType(JSON)
                .body(pautaDTO)
                .when()
                .post("/pautas", pautaDTO)
                .then().log().all()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("Deve abrir uma sessao em uma pauta")
    public void deveAbrirUmaSessaoEmUmaPauta(){
        Mockito.when(this.pautaService.abrirVotacao(any(SessaoDTO.class))).thenReturn(pauta);

        given().contentType(JSON)
                .body(sessaoDTO)
                .when()
                .post("/pautas/abrir", sessaoDTO)
                .then().log().all()
                .statusCode(HttpStatus.ACCEPTED.value());
    }

}
