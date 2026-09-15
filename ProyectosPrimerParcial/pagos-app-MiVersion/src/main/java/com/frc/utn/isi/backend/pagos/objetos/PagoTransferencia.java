package com.frc.utn.isi.backend.pagos.objetos;

import java.time.LocalDateTime;

public class PagoTransferencia extends Pagos {
    private String cbuAliasDestino;
    private String bancoOrigen;

    public PagoTransferencia(int idTransaccion, double monto, LocalDateTime fecha, String cbuAliasDestino,
            String bancoOrigen) {
        super(idTransaccion, monto, fecha);
        this.cbuAliasDestino = cbuAliasDestino;
        this.bancoOrigen = bancoOrigen;
    }

    public void procesar() {
    }

    public String generarRecibo() {
        return "Id Transaccion: " + idTransaccion +
                "\n Monto: " + monto +
                "\nFecha emision: " + fecha +
                "\nCBU/ALIAS Destino: " + cbuAliasDestino +
                "\nBanco Origen: " + bancoOrigen;
    };
}
