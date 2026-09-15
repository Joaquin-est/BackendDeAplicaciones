package com.frc.utn.isi.backend.objetos;

public abstract class Dispositivos {
    protected final String id;
    protected final String nombre;
    protected final String ubicacion;
    List<Evento> eventos;

    public Dispositivos(String id, String nombre, String ubicacion, List<Evento> eventos) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.eventos = eventos;
    }

    public void agregarEvento(Evento evento) {

    }

    public Evento getEventos() {

    }

    public abstract String descripcionEstado();

    public abstract double consumoEstimadoWh();
}
