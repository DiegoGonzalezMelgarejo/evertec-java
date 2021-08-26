package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcepcionTamanioString extends RuntimeException {
    private final Log log= LogFactory.getLog(getClass());

    public  ExcepcionTamanioString(String mensaje){
        super(mensaje);
        this.log.info(mensaje);
    }
}