package com.joaco;

import java.util.ArrayList;
import java.util.Scanner;
import com.joaco.objetos.CuentaBancaria;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int opSelec = -1;
        Scanner scanner = new Scanner(System.in);
        ArrayList<CuentaBancaria> listadoCuenta = new ArrayList<>();

        do {
            // System.out.println("Hello World!");
            System.out.println("Menu Banco");
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Consultar Saldo");
            System.out.println("3. Mostrar informacion Cuenta");
            System.out.println("4. Depositar Dinero");
            System.out.println("5. Extraer Dinero");
            System.out.println("6. Transferir Dinero");
            System.out.println("0. Salir");

            System.out.print("Ingrese opcion: ");
            opSelec = scanner.nextInt();

            if (opSelec == 1) {
                scanner.nextLine();
                System.out.print("Ingrese nombre del titular: ");
                String titular = scanner.nextLine();
                System.out.print("Ingrese numero de cuenta: ");
                int nroCuenta = scanner.nextInt();
                System.out.print("Ingrese saldo a registrar: ");
                double saldo = scanner.nextDouble();

                CuentaBancaria cuenta = new CuentaBancaria(titular, nroCuenta, saldo);
                listadoCuenta.add(cuenta);
                System.out.println("Cuenta registrada con exito.");
            } else if (opSelec == 2) {

                System.out.print("Ingrese nro de cuenta: ");
                int cuenta = scanner.nextInt();

                for (int i = 0; i < listadoCuenta.size(); i++) {
                    if (cuenta == listadoCuenta.get(i).getNroCuenta()) {
                        System.out.println(
                                i + 1 + "_ " + "Titular: " + listadoCuenta.get(i).getTitular() + " Saldo: "
                                        + listadoCuenta.get(i).getSaldo());
                    }
                }
            }

            else if (opSelec == 3) {
                System.out.print("Ingrese nro de cuenta: ");
                int cuenta = scanner.nextInt();

                for (int i = 0; i < listadoCuenta.size(); i++) {
                    if (cuenta == listadoCuenta.get(i).getNroCuenta()) {
                        System.out.println(
                                i + 1 + "_ " + " Nro Cuenta: " + listadoCuenta.get(i).getNroCuenta() + " Titular: "
                                        + listadoCuenta.get(i).getTitular() + " Saldo: "
                                        + listadoCuenta.get(i).getSaldo());
                    }
                }
            }

            else if (opSelec == 4) {
                System.out.print("Ingrese nro de cuenta: ");
                int cuenta = scanner.nextInt();
                System.out.print("Ingrese saldo a depositar: ");
                double saldoNuevo = scanner.nextDouble();

                // double saldoAnterior = 0;
                for (int i = 0; i < listadoCuenta.size(); i++) {
                    if (cuenta == listadoCuenta.get(i).getNroCuenta()) {
                        listadoCuenta.get(i).cargarSaldo(saldoNuevo);
                        /**
                         * saldoAnterior = listadoCuenta.get(i).getSaldo();
                         * listadoCuenta.get(i).setSaldo(saldoAnterior + saldoNuevo);
                         */
                    }
                }
            }

            else if (opSelec == 5) {
                System.out.print("Ingrese nro de cuenta: ");
                int cuenta = scanner.nextInt();
                System.out.print("Ingrese saldo a extraer: ");
                double saldoNuevo = scanner.nextDouble();
                // double saldoAnterior = 0;

                for (int i = 0; i < listadoCuenta.size(); i++) {
                    if (cuenta == listadoCuenta.get(i).getNroCuenta()) {
                        if (!listadoCuenta.get(i).extraerDinero(saldoNuevo)) {
                            System.out.println("Error: Saldo insuficiente.");
                            /*
                             * saldoAnterior = listadoCuenta.get(i).getSaldo();
                             * listadoCuenta.get(i).setSaldo(saldoAnterior - saldoNuevo);
                             */
                        }
                    }
                }

            }

            else if (opSelec == 6) {
                System.out.print("Ingrese nro de cuenta Origen: ");
                int nroCuentaOrigen = scanner.nextInt();
                int nroCuentaDestino = nroCuentaOrigen;
                while (nroCuentaOrigen == nroCuentaDestino) {
                    System.out.print("Ingrese nro de cuenta Destino: ");
                    nroCuentaDestino = scanner.nextInt();
                    if (nroCuentaOrigen == nroCuentaDestino) {
                        System.out.println(
                                "Aviso: No puede realizar transferencias a sí mismo. No sea estúpido, gracias. ");
                    }
                }
                System.out.print("Ingrese saldo a transferir: ");
                double saldoNuevo = scanner.nextDouble();
                int cuentaDestino = -1;
                int cuentaOrigen = -1;

                for (int i = 0; i < listadoCuenta.size(); i++) {
                    if (nroCuentaOrigen == listadoCuenta.get(i).getNroCuenta()) {
                        cuentaOrigen = i;
                    } else if (nroCuentaDestino == listadoCuenta.get(i).getNroCuenta()) {
                        cuentaDestino = i;
                    }
                }

                if (cuentaOrigen != -1 && cuentaDestino != -1) {
                    // listadoCuenta.get(cuentaOrigen).setSaldo(listadoCuenta.get(cuentaOrigen).getSaldo()
                    // - saldoNuevo);
                    // listadoCuenta.get(cuentaOrigen).extraerDinero(saldoNuevo);
                    if (!listadoCuenta.get(cuentaOrigen).extraerDinero(saldoNuevo)) {
                        System.out.println("Error: Saldo insuficiente.");
                    } else {

                        // listadoCuenta.get(cuentaDestino).setSaldo(listadoCuenta.get(cuentaDestino).getSaldo()
                        // + saldoNuevo);
                        listadoCuenta.get(cuentaDestino).cargarSaldo(saldoNuevo);
                    }
                } else {
                    if (cuentaOrigen != -1) {
                        System.out.println("Aviso: Cuenta Origen inexistente.");
                    }
                    if (cuentaDestino != -1) {
                        System.out.println("Aviso: Cuenta Destino inexistente");
                    }
                }
            }
        } while (opSelec != 0);
    }
}