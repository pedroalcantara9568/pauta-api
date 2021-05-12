package com.example.demo.web.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;


@Getter

@AllArgsConstructor
@Builder
public class CpfDTO implements Serializable {

    private String status;
}
