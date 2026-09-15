package com.frc.utn.isi.backend.viajes.objetos;

import java.util.ArrayList;
import java.util.List;

// Innecesario ahora
//import java.util.Iterator;

public class GestorViajes {
    // private final Cliente[] clientes = new Cliente[500];
    private final List<Cliente> clientes = new ArrayList<>();
    // private Viaje[] viajes = new Viaje[500];
    private List<Viaje> viajes = new ArrayList<>();
    // private int contadorClientes;
    // private int contadorVia jes;

    /*
     * public GestorViajes(int maxClientes, int maxViajes) {
     * this.clientes = new Cliente[maxClientes];
     * this.viajes = new Viaje[maxViajes];
     * }
     */

    public Cliente registrarOReutilizarCliente(String nombreEmpresa, String cuit) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCuit().equals(cuit)) {
                return clientes.get(i);
            }
        }
        Cliente nuevo = new Cliente(nombreEmpresa, cuit);
        // clientes[contadorClientes++] = nuevo;
        clientes.add(nuevo);
        return nuevo;
    }

    public void agregarViaje(Viaje viaje) {
        boolean bandera = false;
        for (int i = 0; i < viajes.size(); i++) {
            if (viajes.get(i).codigo.equals(viaje.codigo)) {
                bandera = true;
            }
        }
        if (!bandera) {
            // viajes[contadorViajes++] = viaje;
            viajes.add(viaje);
        }
    }

    public List<Viaje> getListViaje() {
        return viajes;
    }

    public List<Cliente> getListCliente() {
        return clientes;
    }
    // No se requiere ya que List tiene implementacion Iterator
    /*
     * // Implementacion del Iterator
     * 
     * @Override
     * public Iterator<Viaje> iterator() {
     * return new Iterator<Viaje>() {
     * private int indice = 0;
     * 
     * @Override
     * public boolean hasNext() {
     * return indice < contadorViajes; // Solo recorre hasta el contador, no el
     * array completo lleno de nulls
     * }
     * 
     * @Override
     * public Viaje next() {
     * return viajes[indice++];
     * }
     * };
     * }
     */

}
