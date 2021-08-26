package com.evertecjava.evertecjava.infraestructura.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DeudaMysqlExcepcion extends  RuntimeException{
    private final Log log= LogFactory.getLog(getClass());

    public DeudaMysqlExcepcion(String message) {
        super(message);
        log.error(message);

    }
}
