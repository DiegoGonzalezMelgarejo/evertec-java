package com.evertecjava.evertecjava.dominio.entidades;

import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionFormatoFecha;
import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionTamanioString;
import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionValorNegativo;
import lombok.Getter;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Setter
public class Deuda {

    private String identificadorCliente;
    private String nombreCliente;
    private String correo;
    private int monto;
    private String  identificadorDeuda;
    private String  fechaVencimiento;
    private static final String TamanioStringInvalido="El tamaño del string debe ser menor igual a";
    public Deuda(String identificadorCliente, String nombreCliente, String correo,
                 int monto, String identificadorDeuda, String fechaVencimiento) {

        if(identificadorCliente.length()>15) throw  new ExcepcionTamanioString(TamanioStringInvalido+
                identificadorCliente.length());
        if(nombreCliente.length()>60) throw  new ExcepcionTamanioString(TamanioStringInvalido+
                nombreCliente.length());
        if(correo.length()>60) throw  new ExcepcionTamanioString(TamanioStringInvalido+
                correo.length());
        if(String.valueOf(monto).length()>20) throw  new ExcepcionTamanioString(TamanioStringInvalido+
                String.valueOf(monto));
        if(identificadorDeuda.length()>15) throw  new ExcepcionTamanioString(TamanioStringInvalido+
                identificadorDeuda.length());
        if(!validarFormatoFechaPagoNoValido(fechaVencimiento)) throw  new ExcepcionFormatoFecha("");
        if(monto<0) throw new ExcepcionValorNegativo("");
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.monto = monto;
        this.identificadorDeuda = identificadorDeuda;
        this.fechaVencimiento = fechaVencimiento;
    }
    private boolean validarFormatoFechaPagoNoValido(String fechaVencimiento){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            df.parse(fechaVencimiento);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
