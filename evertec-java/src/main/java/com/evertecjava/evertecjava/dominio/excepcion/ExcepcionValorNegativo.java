package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcepcionValorNegativo extends RuntimeException {
    private final Log log= LogFactory.getLog(getClass());

    public  ExcepcionValorNegativo(String mensaje){
        super(mensaje);
        this.log.error(mensaje);
    }
}
