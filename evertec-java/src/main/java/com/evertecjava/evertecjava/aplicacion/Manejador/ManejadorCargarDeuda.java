package com.evertecjava.evertecjava.aplicacion.Manejador;

import com.evertecjava.evertecjava.aplicacion.Dto.DeudaDto;
import com.evertecjava.evertecjava.aplicacion.transformador.DeudaTransformador;
import com.evertecjava.evertecjava.dominio.servicio.CargarDeudaServicio;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Component
public class ManejadorCargarDeuda {
private CargarDeudaServicio cargarDeudaServicio;

    public ManejadorCargarDeuda(CargarDeudaServicio cargarDeudaServicio) {
        this.cargarDeudaServicio = cargarDeudaServicio;
    }

    @Transactional
    public List<DeudaDto> cargarDeudas(MultipartFile multipartFile) throws IOException {
      return DeudaTransformador.CrearListDeudaDto(this.cargarDeudaServicio.cargarDeudas(multipartFile)) ;
    }
}
