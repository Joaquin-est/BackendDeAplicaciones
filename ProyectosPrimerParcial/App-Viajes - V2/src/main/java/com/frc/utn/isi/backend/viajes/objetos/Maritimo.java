package com.frc.utn.isi.backend.viajes.objetos;

// 3
public class Maritimo extends Viaje {
    private String cantidadContenedores;
    private String costoPorKilo;
    private String pesoTransportado;

    public Maritimo(String codigo, String nroReserva, String precio, String tipoViaje, Cliente cliente,
            String cantidadContenedores,
            String costoPorKilo, String pesoTransportado) {
        super(codigo, nroReserva, precio, tipoViaje, cliente);
        this.cantidadContenedores = cantidadContenedores;
        this.costoPorKilo = costoPorKilo;
        this.pesoTransportado = pesoTransportado;
    }

    public String getCantidadContenedores() {
        return cantidadContenedores;
    }

    public String getCostoPorKilo() {
        return costoPorKilo;
    }

    public String getPesoTransportado() {
        return pesoTransportado;
    }
}
