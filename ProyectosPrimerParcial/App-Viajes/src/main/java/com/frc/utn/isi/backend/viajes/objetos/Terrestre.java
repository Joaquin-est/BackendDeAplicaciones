package com.frc.utn.isi.backend.viajes.objetos;

// 2
public class Terrestre extends Viaje {
    private String provinciasVisitadas;
    private String cantidadPasajeros;

    public Terrestre(String codigo, String nroReserva, String precio, String tipoViaje, Cliente cliente,
            String provinciasVisitadas,
            String cantidadPasajeros) {
        super(codigo, nroReserva, precio, tipoViaje, cliente);
        this.provinciasVisitadas = provinciasVisitadas;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getProvinciasVisitadas() {
        return provinciasVisitadas;
    }

    public String getCantidadPasajeros() {
        return cantidadPasajeros;
    }
}
