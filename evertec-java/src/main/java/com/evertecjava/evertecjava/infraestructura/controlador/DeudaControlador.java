package com.evertecjava.evertecjava.infraestructura.controlador;

import com.evertecjava.evertecjava.aplicacion.Dto.DeudaDto;
import com.evertecjava.evertecjava.aplicacion.Manejador.ManejadorCargarDeuda;
import com.evertecjava.evertecjava.aplicacion.Manejador.ManejadorListarDeudas;
import com.evertecjava.evertecjava.infraestructura.controlador.dto.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/deudas")
@Api
public class DeudaControlador {
    private final ManejadorCargarDeuda manejadorCargarDeuda;
    private final ManejadorListarDeudas manejadorListarDeudas;
     private static final String   DEUDASCARGADAS  = "Se han cargado las deudas";
    private final Log log= LogFactory.getLog(getClass());

    public DeudaControlador(ManejadorCargarDeuda manejadorCargarDeuda, ManejadorListarDeudas manejadorListarDeudas) {
        this.manejadorCargarDeuda = manejadorCargarDeuda;
        this.manejadorListarDeudas = manejadorListarDeudas;
    }

    @PostMapping("/")
    @ApiOperation(value = "Carga un archivo plano con las deudas")
    public ResponseEntity<ResponseDto> CargarDeudasArchivoPlano(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException {
this.log.info("Se inicio el proceso de cargar deudas");
        ResponseDto responseDto= new ResponseDto();
        responseDto.setDatos(  this.manejadorCargarDeuda.cargarDeudas(multipartFile));
        responseDto.setMensaje(DEUDASCARGADAS);
        this.log.info("Se termino el proceso de cargar Deudas");
        return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.CREATED);
    }
    @GetMapping("/")
    @ApiOperation(value = "Consultas todas las deudas en la base de datos")
    public ResponseEntity<List<DeudaDto>> ListarDeudas()  {
        this.log.info("Se inicio el proceso de Listar Deudas");
        List<DeudaDto> deudaDtoList=this.manejadorListarDeudas.listarDeudas();
        this.log.info("Se termino el proceso de Listar Deudas");

        return new ResponseEntity<List<DeudaDto>>(deudaDtoList, HttpStatus.CREATED);
    }
}
