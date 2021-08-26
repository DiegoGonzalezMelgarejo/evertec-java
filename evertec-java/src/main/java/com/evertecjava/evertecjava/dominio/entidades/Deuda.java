package com.evertecjava.evertecjava.dominio.entidades;

import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionFormatoFecha;
import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionTamanioString;
import com.evertecjava.evertecjava.dominio.excepcion.ExcepcionValorNegativo;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.StringUtils;

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
    private static final String TamanioStringInvalido="El tamaño del atributo debe ser menor igual a";
    private static final String FormatoFechaInvalido="El formato de la fecha es invalido";
    private static final String MontoInvalido="El monto de la deuda no puede ser negativo";
    public Deuda(String identificadorCliente, String nombreCliente, String correo,
                 int monto, String identificadorDeuda, String fechaVencimiento) {

        if(identificadorCliente.length()>15) throw  new ExcepcionTamanioString("identificadorCliente "+TamanioStringInvalido+
                identificadorCliente.length());
        if(nombreCliente.length()>60) throw  new ExcepcionTamanioString("nombreCliente "+TamanioStringInvalido+
                nombreCliente.length());
        if(correo.length()>60) throw  new ExcepcionTamanioString("correo"+TamanioStringInvalido+
                correo.length());
        if(String.valueOf(monto).length()>20) throw  new ExcepcionTamanioString("monto "+TamanioStringInvalido+
                String.valueOf(monto));
        if(identificadorDeuda.length()>15) throw  new ExcepcionTamanioString("identificadorDeuda"+TamanioStringInvalido+
                identificadorDeuda.length());
        if(!validarFormatoFechaPagoNoValido(fechaVencimiento)) throw  new ExcepcionFormatoFecha(FormatoFechaInvalido);
        if(monto<0) throw new ExcepcionValorNegativo(MontoInvalido);
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.monto = monto;
        this.identificadorDeuda = identificadorDeuda;
        this.fechaVencimiento = fechaVencimiento;
    }
    private boolean validarFormatoFechaPagoNoValido(String fechaVencimiento){
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

        try {
            df.parse(fechaVencimiento);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
