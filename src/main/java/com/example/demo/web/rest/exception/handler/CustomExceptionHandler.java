package com.example.demo.web.rest.exception.handler;

import com.example.demo.web.rest.exception.CpfInvalidoException;
import com.example.demo.web.rest.exception.PautaNaoEncontradaException;
import com.example.demo.web.rest.exception.SessaoFechadaException;
import com.example.demo.web.rest.exception.VotoDuplicadoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(SessaoFechadaException.class)
    public final ResponseEntity<ExceptionResponse> handlePautaFechadaException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PautaNaoEncontradaException.class)
    public final ResponseEntity<ExceptionResponse> handlePautaNaoEncontrada(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CpfInvalidoException.class)
    public final ResponseEntity<ExceptionResponse> handleCpfInvalidoException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(VotoDuplicadoException.class)
    public final ResponseEntity<ExceptionResponse> handleVotoDuplicadoException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse =
                new ExceptionResponse(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
