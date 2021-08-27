package com.evertecjava.evertecjava.infraestructura.configuracion;

import com.evertecjava.evertecjava.dominio.puerto.IPuertoDeuda;
import com.evertecjava.evertecjava.dominio.servicio.CargarDeudaServicio;
import com.evertecjava.evertecjava.dominio.servicio.ListarDeudasServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionServicio {

    @Bean
    public CargarDeudaServicio servicioAgregarPago(IPuertoDeuda puertoDeuda){
        return new CargarDeudaServicio(puertoDeuda);
    }
    @Bean
    public ListarDeudasServicio serviciListarDeuda(IPuertoDeuda puertoDeuda){
        return new ListarDeudasServicio(puertoDeuda);
    }
}
