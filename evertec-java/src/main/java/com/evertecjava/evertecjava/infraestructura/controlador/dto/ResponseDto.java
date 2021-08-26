package com.evertecjava.evertecjava.infraestructura.controlador.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseDto<T> {

    private String mensaje;
    private List<T> datos;
}
