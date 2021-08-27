package com.evertecjava.evertecjava.dominio.servicio;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import com.evertecjava.evertecjava.dominio.puerto.IPuertoDeuda;

import java.util.List;

public class ListarDeudasServicio {
    private IPuertoDeuda puertoDeuda;

    public ListarDeudasServicio(IPuertoDeuda puertoDeuda) {
        this.puertoDeuda = puertoDeuda;
    }

    public List<Deuda> listarDeudas(){
        return this.puertoDeuda.ListarDeudas();
    }
}
