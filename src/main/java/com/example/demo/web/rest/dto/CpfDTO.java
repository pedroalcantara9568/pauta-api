package com.example.demo.web.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Builder
public class CpfDTO implements Serializable {

    private String status;
}
