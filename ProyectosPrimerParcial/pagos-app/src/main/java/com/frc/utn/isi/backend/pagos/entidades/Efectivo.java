package com.frc.utn.isi.backend.pagos.entidades;

import java.time.LocalDateTime;

import javax.management.openmbean.InvalidOpenTypeException;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Data
public class Efectivo extends Pago {
    private double montoRecibido;
    private double vuelto;

    public Efectivo(String idTx, double monto, LocalDateTime fecha, double montoRecibido) {
        super(idTx, montoRecibido, fecha);
        this.montoRecibido = montoRecibido;
        vuelto = 0;
    }

    @Override
    public void procesar() {
        if (montoRecibido < monto)
            throw new IllegalArgumentException("El monto recibido no puede ser inferior al monto de la operacion");
        vuelto = this.montoRecibido - monto;
    }

    @Override
    public String generarRecibo() {
        return "[TICKET FISCAL] Tx: " + getIdTransaccion() + " | Total: $" + getMonto() + " | Recibido: $"
                + montoRecibido + " | Vuelto: $" + vuelto;
    }

    @Override
    public double netoIngresado() {
        return this.vuelto;
    }

}
