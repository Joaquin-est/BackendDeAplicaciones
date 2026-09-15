package com.frc.utn.isi.backend.pagos.objetos;

import java.time.LocalDateTime;

public class PagoTarjeta extends Pagos {
    private String tokenTarjeta;
    private String marca;
    private int cuotas;

    public PagoTarjeta(int idTransaccion, double monto, LocalDateTime fecha, String tokenTarjeta, String marca,
            int cuotas) {
        super(idTransaccion, monto, fecha);
        this.tokenTarjeta = tokenTarjeta;
        this.marca = marca;
        this.cuotas = cuotas;
    }

    public void procesar() {
    }

    public String generarRecibo() {
        return "Id Transaccion: " + idTransaccion +
                "\n Monto: " + monto +
                "\nFecha emision: " + fecha +
                "\nEmpresa Tarjeta: " + marca +
                "\n nro cuotas: " + cuotas;
    };
}
