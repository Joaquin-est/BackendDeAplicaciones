package com.frc.utn.isi.backend.pagos.entidades;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Tarjeta extends Pago {

    private String tokenTarjeta;
    private String marca;
    private int cuotas;
    private double interes;

    private final static double INTERES_CUOTAS = 0.03;

    public Tarjeta(String idTransaccion, double monto, LocalDateTime fecha, String tokenTarjeta, String marca,
            int cuotas) {
        super(idTransaccion, monto, fecha);
        this.tokenTarjeta = tokenTarjeta;
        this.marca = marca;
        this.cuotas = cuotas;
    }

    @Override
    public void procesar() {
        if (cuotas > 3)
            interes = monto * (1 + Tarjeta.INTERES_CUOTAS);
        monto += interes;
    }

    @Override
    public String generarRecibo() {
        return "[VOUCHER ELECTRÓNICO] Tx: " + getIdTransaccion() + " | Tarjeta: " + marca + " (Token: " + tokenTarjeta
                + ") | Plan: " + cuotas + " cuota(s) de $" + (getMonto() / cuotas) + " | Interes $ " + interes;
    }

    @Override
    public double netoIngresado() {
        return this.monto;
    }

}
