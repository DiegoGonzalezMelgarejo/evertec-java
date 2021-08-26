package com.evertecjava.evertecjava.aplicacion.transformador;

import com.evertecjava.evertecjava.aplicacion.Dto.DeudaDto;
import com.evertecjava.evertecjava.dominio.entidades.Deuda;

import java.util.ArrayList;
import java.util.List;

public class DeudaTransformador {


    public static Deuda CrearDeuda(DeudaDto deudaDto){
        return new Deuda(deudaDto.getIdentificadorCliente(),deudaDto.getNombreCliente(),deudaDto.getCorreo(),
                deudaDto.getMonto(),deudaDto.getIdentificadorDeuda(),deudaDto.getFechaVencimiento());
    }

    public static DeudaDto crearDeudaDto(Deuda deuda){
        return new DeudaDto(deuda.getIdentificadorCliente(),deuda.getNombreCliente(),deuda.getCorreo(),
                deuda.getMonto(),deuda.getIdentificadorDeuda(),deuda.getFechaVencimiento());
    }
    public static List<DeudaDto> CrearListDeudaDto(List<Deuda> deudas){
        List<DeudaDto> deudaDtos=new ArrayList<>();
        deudas.forEach((final Deuda deuda)->deudaDtos.add(crearDeudaDto(deuda)));
        return deudaDtos;
    }
}
