package com.frc.utn.isi.backend.viajes.objetos;

public class ViajeFactory {
    public static Viaje crear(String[] campos, Cliente cliente) {
        String tipoViaje = campos[3];
        // GestorViajes gestor = new GestorViajes();
        // Cliente cliente = gestor.registrarOReutilizarCliente(campos[11], campos[12]);

        switch (tipoViaje) {
            case "1" -> {
                return new Aereo(campos[0], campos[1], campos[2], campos[3], cliente,
                        campos[4], campos[5]);
            }
            case "2" -> {
                return new Terrestre(campos[0], campos[1], campos[2], campos[3],
                        cliente, campos[6], campos[7]);
            }
            case "3" -> {
                return new Maritimo(campos[0], campos[1], campos[2], campos[3],
                        cliente, campos[8], campos[9], campos[10]);
            }
            default -> {/*
                         * throw new IllegalArgumentException(
                         * "Tipo de viaje desconocido: " + tipoViaje)
                         */
                return null;
            }
        }
    }
}