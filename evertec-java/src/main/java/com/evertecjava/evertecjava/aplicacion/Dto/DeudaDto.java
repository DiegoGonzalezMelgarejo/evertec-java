package com.evertecjava.evertecjava.aplicacion.Dto;

import lombok.Getter;

@Getter
public class DeudaDto {
    private String identificadorCliente;
    private String nombreCliente;
    private String correo;
    private int monto;
    private String  identificadorDeuda;
    private String  fechaVencimiento;

    public DeudaDto(String identificadorCliente, String nombreCliente, String correo, int monto, String identificadorDeuda, String fechaVencimiento) {
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.monto = monto;
        this.identificadorDeuda = identificadorDeuda;
        this.fechaVencimiento = fechaVencimiento;
    }
}
