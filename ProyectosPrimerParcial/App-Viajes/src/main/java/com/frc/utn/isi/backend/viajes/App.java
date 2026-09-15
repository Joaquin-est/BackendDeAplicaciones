package com.frc.utn.isi.backend.viajes;

import java.io.BufferedReader;
import java.io.FileReader;

import com.frc.utn.isi.backend.viajes.objetos.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        try (BufferedReader br = new BufferedReader(
                new FileReader("./src/main/java/com/frc/utn/isi/backend/viajes/data/viajes.csv"))) {
            String linea;
            // GestorViajes gestor = new GestorViajes(150, 150);
            GestorViajes gestor = new GestorViajes();
            boolean primerLinea = true;
            Viaje vuelo = null;

            while ((linea = br.readLine()) != null) {
                if (primerLinea == true) {
                    primerLinea = false;
                    continue;
                }
                String[] palabras = linea.split(";");
                // System.out.println(palabras[3]); //Para saber si es la columna adecuada

                Cliente cliente = gestor.registrarOReutilizarCliente(palabras[11], palabras[12]);
                /*
                 * switch (palabras[3]) {
                 * case "1" -> {
                 * // Aereo
                 * vuelo = new Aereo(palabras[0], palabras[1], palabras[2], palabras[3],
                 * cliente,
                 * palabras[4], palabras[5]);
                 * }
                 * case "2" -> {
                 * // Terrestre
                 * vuelo = new Terrestre(palabras[0], palabras[1], palabras[2], palabras[3],
                 * cliente,
                 * palabras[6], palabras[7]);
                 * }
                 * case "3" -> {
                 * // Maritimo
                 * vuelo = new Maritimo(palabras[0], palabras[1], palabras[2], palabras[3],
                 * cliente,
                 * palabras[8], palabras[9], palabras[10]);
                 * }
                 * default -> {
                 * vuelo = null;
                 * }
                 * }
                 */

                vuelo = ViajeFactory.crear(palabras, cliente);
                if (vuelo != null) {
                    gestor.agregarViaje(vuelo);
                }
                // for (String palabra : palabras){
                // }
                // System.out.println(linea);
            }
            for (Viaje v : gestor) {
                // 1. Imprimimos los datos en común que tienen TODOS los viajes
                System.out.println("==================================================");
                System.out.print("CÓDIGO: " + v.getCodigo() + " | Reserva: " + v.getNroReserva());
                System.out.println(" | Precio Base: $" + v.getPrecio() + " | Tipo: " + v.getTipoViaje());

                // Accedemos a los datos del Cliente asociado a este viaje
                System.out.println(
                        "Cliente: " + v.getCliente().getNombreEmpresa() + " (CUIT: " + v.getCliente().getCuit() + ")");

                // 2. Evaluamos qué tipo de viaje específico es para mostrar sus datos únicos
                if (v instanceof Aereo) {
                    // Casteo polimórfico a Aereo
                    Aereo va = (Aereo) v; // Cast o Casteo
                    System.out.println(
                            "[AÉREO] Aerolínea: " + va.getCodAerolinea() + " | Millas: " + va.getMillasAcumuladas());

                } else if (v instanceof Terrestre) {
                    // Casteo polimórfico a Terrestre
                    Terrestre vt = (Terrestre) v;
                    System.out.println("[TERRESTRE] Pasajeros: " + vt.getCantidadPasajeros() + " | Provincias: "
                            + vt.getProvinciasVisitadas());

                } else if (v instanceof Maritimo) {
                    // Casteo polimórfico a Maritimo
                    Maritimo vm = (Maritimo) v;
                    System.out.println("[MARÍTIMO] Contenedores: " + vm.getCantidadContenedores());
                    System.out.println(
                            "   Peso: " + vm.getPesoTransportado() + " kg | Costo por Kilo: $" + vm.getCostoPorKilo());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        ;
    }
}
