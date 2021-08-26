package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ArchivoException extends RuntimeException{
    private final Log log= LogFactory.getLog(getClass());

    public ArchivoException(String mensaje) {
        super(mensaje);
        this.log.error(mensaje);
    }
}
