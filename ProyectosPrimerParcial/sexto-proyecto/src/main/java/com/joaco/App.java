package com.joaco;

import java.util.Scanner;

import com.objetos.Mascota;

/**
 * Hello world!
 */

public class App {
    public static void mostrarMenu() {
        System.out.println("----------------------------------------------");

        System.out.println("Comportamientos de ingesta: ");
        System.out.println("1. Comer");
        System.out.println("2. Beber");

        System.out.println("Comportamientos de actividades: ");
        System.out.println("3. Correr");
        System.out.println("4. saltar");

        System.out.println("Otros: ");
        System.out.println("5. dormir");
        System.out.println("6. despertar");
        System.out.println("-1. Salir");
        System.out.println("----------------------------------------------");
    }

    public static void validarVidaMascota(Mascota mascota) {
        if (mascota.estavivo() == false) {
            System.out.print("Lamentamos informarle que su Mascota a fallecido de cansancio.");
        }
    }

    public static void main(String[] args) {
        // System.out.println("Hello World!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a YourPetApp");
        System.out.print("Ingrese el nombre de su mascota: ");

        // Mascota
        String nombre = scanner.nextLine();
        int energia = 50;
        int humor = 3; // Neutral

        Mascota mascota = new Mascota(nombre, energia, humor);

        // Selector de opcion
        int opSelec = 0;
        // Contadores / Acumuladores
        int contIngesta = 0;
        int contActividad = 0;

        do {
            mostrarMenu();
            opSelec = scanner.nextInt();

            if (opSelec == 1) {
                validarVidaMascota(mascota);
                contIngesta += 1;
                contActividad = 0;
                mascota.comer(contIngesta);
                System.out.println("Su mascota fue alimentada...");
            }

            if (opSelec == 2) {
                validarVidaMascota(mascota);
                contIngesta += 1;
                contActividad = 0;
                mascota.beber(contIngesta);
                System.out.println("Su mascota fue hidratada...");
            }
            if (opSelec == 3) {
                validarVidaMascota(mascota);
                contActividad += 1;
                mascota.correr(contActividad);
                contIngesta = 0;
                System.out.println(mascota.toString());
            }
            if (opSelec == 4) {
                validarVidaMascota(mascota);
                contActividad += 1;
                contIngesta = 0;
                mascota.saltar(contActividad);
                System.out.println(mascota.toString());
            }
            if (opSelec == 5) {
                validarVidaMascota(mascota);
                contIngesta = 0;
                contActividad = 0;
                mascota.dormir();
                System.out.println(mascota.toString());
            }
            if (opSelec == 6) {
                validarVidaMascota(mascota);
                contIngesta = 0;
                contActividad = 0;
                mascota.despertar();
                System.out.println(mascota.toString());
            }

        } while (opSelec != -1);
    }
}
