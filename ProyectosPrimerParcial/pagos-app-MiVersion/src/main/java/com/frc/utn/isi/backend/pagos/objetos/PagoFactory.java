package com.frc.utn.isi.backend.pagos.objetos;

//package com.frc.utn.isi.backend.pagos.factory;

import java.util.Map;

import com.frc.utn.isi.backend.pagos.objetos.PagoEfectivo;
import com.frc.utn.isi.backend.pagos.objetos.PagoTarjeta;
import com.frc.utn.isi.backend.pagos.objetos.PagoTransferencia;
import com.frc.utn.isi.backend.pagos.objetos.Pagos;

public class PagoFactory {

    public static Pagos crearPago(
            String tipoPago,
            int idTx,
            double monto,
            Map<String, Object> metadata) {

        switch (tipoPago.toUpperCase()) {

            case "EFECTIVO":
                double recibido = (double) metadata.getOrDefault(
                        "montoRecibido",
                        monto);

                return new PagoEfectivo(
                        idTx,
                        monto,
                        fecha,
                        recibido);

            case "TRANSFERENCIA":
                String cbu = (String) metadata.get("cbuAliasDestino");
                String banco = (String) metadata.get("bancoOrigen");

                return new PagoTransferencia(
                        idTx,
                        monto,
                        cbu,
                        banco);

            case "TARJETA":
                String token = (String) metadata.get("tokenTarjeta");
                String marca = (String) metadata.get("marca");
                int cuotas = (int) metadata.getOrDefault("cuotas", 1);

                return new PagoTarjeta(
                        idTx,
                        monto,
                        token,
                        marca,
                        cuotas);

            default:
                throw new IllegalArgumentException(
                        "Medio de pago no soportado: " + tipoPago);
        }
    }
}
