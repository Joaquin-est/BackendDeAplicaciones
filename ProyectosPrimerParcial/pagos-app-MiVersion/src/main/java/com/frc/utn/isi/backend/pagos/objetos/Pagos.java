package com.frc.utn.isi.backend.pagos.objetos;

import java.time.LocalDateTime;

public abstract class Pagos {
    protected int idTransaccion;
    protected double monto;
    protected LocalDateTime fecha;

    public Pagos(int idTransaccion, double monto, LocalDateTime fecha) {
        this.idTransaccion = idTransaccion;
        this.monto = monto;
        this.fecha = fecha;
    }

    public abstract void procesar();

    public abstract String generarRecibo();
}
