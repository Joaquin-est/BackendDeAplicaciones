package com.frc.utn.isi.backend.viajes.objetos;

import java.util.Iterator;

public class GestorViajes implements Iterable<Viaje> {
    private final Cliente[] clientes = new Cliente[500];
    private Viaje[] viajes = new Viaje[500];
    private int contadorClientes;
    private int contadorViajes;

    /*
     * public GestorViajes(int maxClientes, int maxViajes) {
     * this.clientes = new Cliente[maxClientes];
     * this.viajes = new Viaje[maxViajes];
     * }
     */

    public Cliente registrarOReutilizarCliente(String nombreEmpresa, String cuit) {
        for (int i = 0; i < contadorClientes; i++) {
            if (clientes[i].getCuit().equals(cuit)) {
                return clientes[i];
            }
        }
        Cliente nuevo = new Cliente(nombreEmpresa, cuit);
        clientes[contadorClientes++] = nuevo;
        return nuevo;
    }

    public void agregarViaje(Viaje viaje) {
        boolean bandera = false;
        for (int i = 0; i < contadorViajes; i++) {
            if (viajes[i].codigo.equals(viaje.codigo)) {
                bandera = true;
            }
        }
        if (bandera == false && contadorViajes < viajes.length) {
            viajes[contadorViajes++] = viaje;
        }
    }

    // Implementacion del Iterator
    @Override
    public Iterator<Viaje> iterator() {
        return new Iterator<Viaje>() {
            private int indice = 0;

            @Override
            public boolean hasNext() {
                return indice < contadorViajes; // Solo recorre hasta el contador, no el array completo lleno de nulls
            }

            @Override
            public Viaje next() {
                return viajes[indice++];
            }
        };
    }

}
