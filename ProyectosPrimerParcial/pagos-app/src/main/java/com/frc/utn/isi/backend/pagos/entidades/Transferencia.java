package com.frc.utn.isi.backend.pagos.entidades;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Transferencia extends Pago {
    private String cbuAliasDestino;
    private String bancoOrigen;

    private final static double COSTO_BANCARIO = 0.035;

    public Transferencia(String idTransaccion, double monto, LocalDateTime fecha, String cbuAliasDestino,
            String bancoOrigen) {
        super(idTransaccion, monto, fecha);
        this.cbuAliasDestino = cbuAliasDestino;
        this.bancoOrigen = bancoOrigen;
    }

    @Override
    public void procesar() {
        double costos = (monto * (1 + Transferencia.COSTO_BANCARIO)) - monto;
        monto += costos;
    }

    @Override
    public String generarRecibo() {
        double costos = (monto * (1 + Transferencia.COSTO_BANCARIO)) - monto;
        return "[COMPROBANTE TRANSFERENCIA] Tx: " + getIdTransaccion() + " | Enviado a: " + cbuAliasDestino
                + " | Monto: $" + getMonto() + " | Costo Bancarios: $" + costos;
    }

    @Override
    public double netoIngresado() {
        return monto;
    }

}
