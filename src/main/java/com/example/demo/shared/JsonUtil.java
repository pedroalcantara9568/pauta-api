package com.example.demo.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public interface JsonUtil {

    static String toJson(Object object) {
        ObjectWriter ow = new ObjectMapper().writer();
        String mensagem = null;
        try {
            mensagem = ow.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return mensagem;
    }
}
