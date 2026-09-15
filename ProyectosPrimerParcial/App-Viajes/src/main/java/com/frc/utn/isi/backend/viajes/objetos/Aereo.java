package com.frc.utn.isi.backend.viajes.objetos;

// 1
public class Aereo extends Viaje {
    private String millasAcumuladas;
    private String codAereolinea;

    public Aereo(String codigo, String nroReserva, String precio, String tipoViaje, Cliente cliente,
            String millasAcumuladas,
            String codAereolinea) {
        super(codigo, nroReserva, precio, tipoViaje, cliente);
        this.millasAcumuladas = millasAcumuladas;
        this.codAereolinea = codAereolinea;
    }

    public String getCodAerolinea() {
        return codAereolinea;
    }

    public String getMillasAcumuladas() {
        return millasAcumuladas;
    }

}
