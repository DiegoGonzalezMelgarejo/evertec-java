package com.evertecjava.evertecjava.dominio.servicio;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import com.evertecjava.evertecjava.dominio.puerto.PuertoDeuda;

import java.util.List;

public class ListarDeudasServicio {
    private PuertoDeuda puertoDeuda;

    public ListarDeudasServicio(PuertoDeuda puertoDeuda) {
        this.puertoDeuda = puertoDeuda;
    }

    public List<Deuda> listarDeudas(){
        return this.puertoDeuda.ListarDeudas();
    }
}
