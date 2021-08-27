package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ExcepcionArchivo extends RuntimeException{
    private final Log log= LogFactory.getLog(getClass());

    public ExcepcionArchivo(String mensaje) {
        super(mensaje);
        this.log.error(mensaje);
    }
}
