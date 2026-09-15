package com.joaco.objetos;

public abstract class Viaje {
    private int codigo;
    protected int nroReserva;
    protected double precio;
    protected int tipoViaje;
    protected Object cliente;

    public Viaje(int codigo, int nroReserva, double precio, int tipoViaje, Object cliente) {
        this.nroReserva = nroReserva;
        this.precio = precio;
        this.tipoViaje = tipoViaje;
        this.cliente = cliente;
        this.codigo = codigo;
    }
}

public class Aereo extends Viaje {
    protected double millasAcumuladas;
    private int codigoAerolinea;
}