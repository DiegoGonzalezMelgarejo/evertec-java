package com.evertecjava.evertecjava.aplicacion.Manejador;

import com.evertecjava.evertecjava.aplicacion.Dto.DeudaDto;
import com.evertecjava.evertecjava.aplicacion.transformador.DeudaTransformador;
import com.evertecjava.evertecjava.dominio.puerto.IPuertoDeuda;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
@Component
public class ManejadorListarDeudas {

    private IPuertoDeuda puertoDeuda;

    public ManejadorListarDeudas(    IPuertoDeuda puertoDeuda) {

        this.puertoDeuda = puertoDeuda;
    }
    @Transactional
    public List<DeudaDto> listarDeudas(){
        return DeudaTransformador.CrearListDeudaDto(this.puertoDeuda.ListarDeudas());
    }
}
