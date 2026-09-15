package com.frc.utn.isi.backend.pagos.entidades;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class Pago {

    protected String idTransaccion;
    protected double monto;
    protected LocalDateTime fecha;

    public Pago(String idTransaccion, double monto, LocalDateTime fecha) {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public abstract void procesar();

    public abstract String generarRecibo();

    public abstract double netoIngresado();

}
