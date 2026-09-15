package com.frc.utn.isi.backend.pagos.objetos;

import java.time.LocalDateTime;

public class PagoEfectivo extends Pagos {
    private double montoRecibido;

    public PagoEfectivo(int idTransaccion, double monto, LocalDateTime fecha, double montoRecibido) {
        super(idTransaccion, monto, fecha);
        this.montoRecibido = montoRecibido;
    }

    public void procesar() {

    }

    public String generarRecibo() {
        return "Id Transaccion: " + idTransaccion +
                "\n Monto: " + monto +
                "\nFecha emision: " + fecha +
                "\nMonto recibido " + montoRecibido;
    };
}
