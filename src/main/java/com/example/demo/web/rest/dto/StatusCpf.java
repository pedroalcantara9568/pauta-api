package com.example.demo.web.rest.dto;

import java.io.Serializable;


public class StatusCpf implements Serializable {

    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
