package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcepcionFormatoFecha extends RuntimeException {
    private final Log log= LogFactory.getLog(getClass());

    public  ExcepcionFormatoFecha(String mensaje){
        super(mensaje);
        this.log.error(mensaje);
    }
}
