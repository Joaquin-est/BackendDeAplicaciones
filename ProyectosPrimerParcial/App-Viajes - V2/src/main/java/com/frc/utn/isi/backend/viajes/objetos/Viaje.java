package com.frc.utn.isi.backend.viajes.objetos;

public abstract class Viaje {
    protected String codigo;
    protected String nroReserva;
    protected String precio;
    protected String tipoViaje;
    protected Cliente cliente;

    public Viaje(String codigo, String nroReserva, String precio, String tipoViaje, Cliente cliente) {
        this.codigo = codigo;
        this.nroReserva = nroReserva;
        this.precio = precio;
        this.tipoViaje = tipoViaje;
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNroReserva() {
        return nroReserva;
    }

    public String getPrecio() {
        return precio;
    }

    public String getTipoViaje() {
        return tipoViaje;
    }

    public Cliente getCliente() {
        return cliente;
    }
}
