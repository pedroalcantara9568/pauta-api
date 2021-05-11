package com.example.demo.web.rest.dto;

import lombok.*;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CpfDTO implements Serializable {


    private String status;
}
