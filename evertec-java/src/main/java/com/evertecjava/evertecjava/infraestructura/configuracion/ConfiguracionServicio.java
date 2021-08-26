package com.evertecjava.evertecjava.infraestructura.configuracion;

import com.evertecjava.evertecjava.dominio.puerto.PuertoDeuda;
import com.evertecjava.evertecjava.dominio.servicio.CargarDeudaServicio;
import com.evertecjava.evertecjava.dominio.servicio.ListarDeudasServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionServicio {

    @Bean
    public CargarDeudaServicio servicioAgregarPago(PuertoDeuda puertoDeuda){
        return new CargarDeudaServicio(puertoDeuda);
    }
    @Bean
    public ListarDeudasServicio serviciListarDeuda(PuertoDeuda puertoDeuda){
        return new ListarDeudasServicio(puertoDeuda);
    }
}
