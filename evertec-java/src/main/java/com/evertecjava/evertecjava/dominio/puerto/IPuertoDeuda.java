package com.evertecjava.evertecjava.dominio.puerto;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPuertoDeuda {

    void cargarDeudas(List<Deuda>deudas);
    List<Deuda> ListarDeudas();

}
