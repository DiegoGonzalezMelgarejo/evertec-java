package com.evertecjava.evertecjava.dominio.excepcion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeudaException extends  RuntimeException{
    private final Log log= LogFactory.getLog(getClass());

    public DeudaException(String message) {

        super(message);
        this.log.error(message);

    }
}
