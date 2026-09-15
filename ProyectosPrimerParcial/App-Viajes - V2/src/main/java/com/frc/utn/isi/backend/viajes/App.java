package com.frc.utn.isi.backend.viajes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.stream.Collectors;

import java.util.List;

import com.frc.utn.isi.backend.viajes.objetos.*;

/**
 * Hello world!
 */
public class App {
    public static void menu(Viaje v){
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
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        try (BufferedReader br = new BufferedReader(
                new FileReader("./src/main/java/com/frc/utn/isi/backend/viajes/data/viajes.csv"))) {
            GestorViajes gestor = new GestorViajes();

            List<Viaje> viajes = br.lines()
                    .skip(1)
                    .map(linea -> linea.split(";"))
                    .map(palabras -> {
                        Cliente cliente = gestor.registrarOReutilizarCliente(palabras[11], palabras[12]);
                        return ViajeFactory.crear(palabras, cliente);
                    })
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());

            for (Viaje v : viajes) {
                // 1. Imprimimos los datos en común que tienen TODOS los viajes
                menu(v);
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
        ;
    }
}
