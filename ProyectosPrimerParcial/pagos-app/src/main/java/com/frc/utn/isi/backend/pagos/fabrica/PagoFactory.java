package com.frc.utn.isi.backend.pagos.fabrica;

import java.time.LocalDateTime;

import com.frc.utn.isi.backend.pagos.entidades.Efectivo;
import com.frc.utn.isi.backend.pagos.entidades.Pago;
import com.frc.utn.isi.backend.pagos.entidades.Tarjeta;
import com.frc.utn.isi.backend.pagos.entidades.Transferencia;

public class PagoFactory {

    public static Pago crearPago(String tipoPago, String transaccion, String monto,
            String fecha, String recibido,
            String cbu, String banco, String token, String marca, String cuotas) {

        double montoTransaccion = Double.parseDouble(monto);
        LocalDateTime fechaTransaccion = LocalDateTime.parse(fecha);

        switch (tipoPago.toUpperCase()) {
            case "EFECTIVO":
                double montoRecibido = Double.parseDouble(monto);
                return new Efectivo(transaccion, montoTransaccion, fechaTransaccion, montoRecibido);

            case "TRANSFERENCIA":
                return new Transferencia(transaccion, montoTransaccion, fechaTransaccion, cbu, banco);

            case "TARJETA":
                int cuotasElegidas = Integer.parseInt(cuotas);
                return new Tarjeta(transaccion, montoTransaccion, fechaTransaccion, token, marca, cuotasElegidas);

            default:
                throw new IllegalArgumentException("Medio de pago no soportado: " + tipoPago);
        }
    }

}
