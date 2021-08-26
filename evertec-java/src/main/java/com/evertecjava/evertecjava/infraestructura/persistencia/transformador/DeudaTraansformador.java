package com.evertecjava.evertecjava.infraestructura.persistencia.transformador;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import com.evertecjava.evertecjava.infraestructura.persistencia.entidad.DeudaEntidad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DeudaTraansformador {

    public static List<Deuda> convertirListaPagoEntityAListaPagoDominio(List<DeudaEntidad> deudaEntidads){
        List<Deuda> deudas= new ArrayList<>();
        deudaEntidads.forEach((final DeudaEntidad deudaEntidad)->deudas.add(convertirPagoEntityAPagoDominio(deudaEntidad)));
        return deudas;
    }
    private static Deuda convertirPagoEntityAPagoDominio(DeudaEntidad deudaEntidad){
        return  new Deuda(deudaEntidad.getIdentificadorCliente(),deudaEntidad.getNombreCliente(),
                deudaEntidad.getCorreo(), deudaEntidad.getMonto(),
                deudaEntidad.getIdentificadorDeuda(),deudaEntidad.getFechaVencimiento().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
    public  static DeudaEntidad convertirDeudaDominioADeudaEntity(Deuda deuda){
        return new DeudaEntidad(deuda.getIdentificadorDeuda(),deuda.getIdentificadorCliente(),
                deuda.getNombreCliente(),deuda.getCorreo(),deuda.getMonto(),
                LocalDate.parse(deuda.getFechaVencimiento(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
