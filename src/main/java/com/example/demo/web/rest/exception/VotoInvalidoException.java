package com.example.demo.web.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class VotoInvalidoException extends RuntimeException {

    public VotoInvalidoException(String exception) {
        super(exception);
    }

}
