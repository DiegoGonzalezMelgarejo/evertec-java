package com.evertecjava.evertecjava.dominio.servicio;

import com.evertecjava.evertecjava.dominio.entidades.Deuda;
import com.evertecjava.evertecjava.dominio.excepcion.ArchivoException;
import com.evertecjava.evertecjava.dominio.excepcion.DeudaException;
import com.evertecjava.evertecjava.dominio.puerto.PuertoDeuda;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CargarDeudaServicio {

    private PuertoDeuda puertoDeuda;
    private List<Deuda> deudas;
    private static final String  ARCHIVOVACIO="Necesitas Cargar un archivo";
    private static final String  EXTENSION="txt";
    private static final String  FORMATODEUDA="El archivo plano no tiene formato de deudas";
    private static final String  NOHAYDEUDAS="No hay deudas en el archivo plano";
    private static final String  EXTENSIONNOVALIDA="Extension no valida solo se permite txt";
    private static final String  DEUDAREPETIDA="Hay deudas que ya existen en el sistema";
    private final Log log= LogFactory.getLog(getClass());
    public CargarDeudaServicio(PuertoDeuda puertoDeuda) {
        this.puertoDeuda = puertoDeuda;
        this.deudas= new ArrayList<>();
    }

    public  List<Deuda> cargarDeudas(MultipartFile multipartFile) throws IOException {

        if(multipartFile.isEmpty()) throw  new ArchivoException(ARCHIVOVACIO);
        String[] fileFrags = multipartFile.getOriginalFilename().split("\\.");
        String extension = fileFrags[fileFrags.length-1];
        if(!EXTENSION.equalsIgnoreCase(extension)) throw new ArchivoException(EXTENSIONNOVALIDA);
        this.log.info("Se empezo a leer el archivo "+multipartFile.getOriginalFilename());
        this.leerArchivo(multipartFile.getInputStream());
        if(this.deudas.size()==0)throw  new DeudaException(NOHAYDEUDAS);
        List<Deuda>deudasBaseDeDatos=this.puertoDeuda.ListarDeudas();

        for (Deuda deuda: deudas) {
            if(deudasBaseDeDatos.contains(deuda)) throw  new DeudaException(DEUDAREPETIDA);
        }

        this.puertoDeuda.cargarDeudas(deudas);
        this.log.info("Las deudas se cargaron correctamente");
        return this.deudas;
    }

    public void leerArchivo(InputStream inputStream){
        try {

            BufferedReader br;
            String line;
            InputStream is = inputStream;
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
               String atributos[]=line.split(";");
                this.agregarDeuda(atributos);
            }

        } catch (IOException e) {
            this.log.error("Error al leer archivo" + e.getMessage());
            throw  new ArchivoException(e.getMessage());
        }
    }

    private  void agregarDeuda(String deudas[]){
if(deudas.length!=7) throw new DeudaException(FORMATODEUDA);
         this.deudas.add(new Deuda(deudas[0],deudas[1],deudas[2],Integer.parseInt(deudas[3]),deudas[4],deudas[5]));



    }
}
