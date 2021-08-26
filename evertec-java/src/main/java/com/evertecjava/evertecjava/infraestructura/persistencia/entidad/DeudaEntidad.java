package com.evertecjava.evertecjava.infraestructura.persistencia.entidad;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name="Deuda")
@NamedQueries({
        @NamedQuery(name = "Deuda.findAll",query = "SELECT deudas FROM Deuda deudas"),

})
public class DeudaEntidad {
    @Id
    @Column(length = 15)
    private String identificadorDeuda;
    @Column(length = 15)
    private String identificadorCliente;
    @Column(length = 60)

    private String nombreCliente;
    @Column(length = 60)

    private String correo;
    @Column(length = 20)

    private int monto;


    private LocalDate fechaVencimiento;

    public DeudaEntidad(String identificadorDeuda, String identificadorCliente,
                        String nombreCliente, String correo, int monto, LocalDate fechaVencimiento) {
        this.identificadorDeuda = identificadorDeuda;
        this.identificadorCliente = identificadorCliente;
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.monto = monto;
        this.fechaVencimiento = fechaVencimiento;
    }

    public DeudaEntidad() {

    }

    public String getIdentificadorDeuda() {
        return identificadorDeuda;
    }

    public void setIdentificadorDeuda(String identificadorDeuda) {
        this.identificadorDeuda = identificadorDeuda;
    }

    public String getIdentificadorCliente() {
        return identificadorCliente;
    }

    public void setIdentificadorCliente(String identificadorCliente) {
        this.identificadorCliente = identificadorCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    public LocalDate getFechaVencimiento(){

        return this.fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
