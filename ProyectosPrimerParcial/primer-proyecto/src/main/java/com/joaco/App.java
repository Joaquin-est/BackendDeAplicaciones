package com.joaco;

import java.util.Scanner;
import com.joaco.objetos.Fraccionario;
import com.joaco.objetos.Operaciones;

/**
 * class Estudiante {
 * int legajo;
 * double nota;
 * 
 * public Estudiante(int legajo, double nota) {
 * this.legajo = legajo;
 * this.nota = nota;
 * }
 * }
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el numerador de la primera fraccion: ");
        int primerNumerador = scanner.nextInt();
        System.out.print("Ingrese el denominador de la primera fraccion: ");
        int primerDenominador = scanner.nextInt();

        System.out.print("Ingrese el numerador de la segunda fraccion: ");
        int segundoNumerador = scanner.nextInt();
        System.out.print("Ingrese el denominador de la segunda fraccion: ");
        int segundoDenominador = scanner.nextInt();

        Fraccionario primerFraccion = new Fraccionario(primerNumerador, primerDenominador);
        Fraccionario segundaFraccion = new Fraccionario(segundoNumerador, segundoDenominador);
        Operaciones operaciones = new Operaciones(primerFraccion, segundaFraccion);

        System.out.println("Suma: " + operaciones.sumar());
        System.out.println("Resta: " + operaciones.restar());
        System.out.println("Multiplicacion: " + operaciones.multiplicar());
        System.out.println("Division: " + operaciones.dividir());
        scanner.close();
    };
}
/**
 * public class App {
 * public static void mostrarMenu() {
 * System.out.println("=========================");
 * System.out.println("SISTEMA DE ALUMNOS\n");
 * System.out.println("=========================");
 * System.out.println("1. Cargar notas");
 * System.out.println("2. Mostrar estadísticas");
 * System.out.println("3. Buscar una nota");
 * System.out.println("4. Mostrar notas aprobadas");
 * System.out.println("0. Salir");
 * };
 * public static void buscarEstudiante(ArrayList<Estudiante> listadoEstudiantes,
 * Scanner miEscaner){
 * int contEst = 0;
 * System.out.print("Ingrese nota a buscar: ");
 * double notaEnBusqueda = miEscaner.nextDouble();
 * System.out.println("Los estudiantes que calificaron con " + notaEnBusqueda +
 * " son:");
 * for (int i = 0; i < listadoEstudiantes.size(); i++){
 * if (notaEnBusqueda == listadoEstudiantes.get(i).nota){
 * contEst += 1;
 * System.out.println("Estudiante legajo" + listadoEstudiantes.get(i).legajo);
 * }
 * }
 * System.out.println("Cantidad de alumnos que calificaron con "+ notaEnBusqueda
 * + " :" + contEst);
 * };
 * 
 * public static void validarEstudiantesCargados(ArrayList<Estudiante>
 * listadoEstudiantes, Runnable metodo){
 * if (listadoEstudiantes.size() != 0){
 * metodo.run();
 * } else {System.out.println("Aviso: Debe seleccionar opcion 1 antes de
 * seleccionar esta opcion.");}
 * };
 * public static void cargarEstudiantes(ArrayList<Estudiante>
 * listadoEstudiantes, Scanner miEscaner) {
 * double nota = 0;
 * 
 * do {
 * System.out.print("Ingrese el numero de legajo: ");
 * int legajo = miEscaner.nextInt();
 * System.out.print("Ingrese una nota (-1 para finalizar): ");
 * nota = miEscaner.nextDouble();
 * if (nota >= 1 && nota <= 10){
 * System.out.println("Nota registrada");
 * //listadoEstudiantes.add(nota);
 * Estudiante nuevo = new Estudiante(legajo, nota);
 * listadoEstudiantes.add(nuevo);
 * }
 * else if (nota != -1){
 * System.out.println("Nota inválida");
 * };
 * } while (nota != -1);
 * };
 * public static void generarInformeEstadistico(ArrayList<Estudiante>
 * listadoEstudiantes, double promedio, int countAprobados, int
 * countDesaprobados, double notaMax, double notaMin) {
 * System.out.println("Informe Estadístico");
 * System.out.println("Cantidad: " + listadoEstudiantes.size());
 * System.out.println("Promedio: " + promedio);
 * System.out.println("Aprobados: " + countAprobados);
 * System.out.println("Desaprobados: " + countDesaprobados);
 * System.out.println("Nota máxima: " + notaMax);
 * System.out.println("Nota mínima: " + notaMin);
 * };
 * public static void mostrarEstadistica(ArrayList<Estudiante>
 * listadoEstudiantes){
 * double sumNotas = 0;
 * double promedio = 0;
 * int countAprobados = 0;
 * int countDesaprobados = 0;
 * double notaMax = 0;
 * double notaMin = 0;
 * //System.out.println("Opcion Seleccionada: Mostrar estadistica");
 * notaMax = listadoEstudiantes.get(0).nota;
 * notaMin = listadoEstudiantes.get(0).nota;
 * for (int i = 0; i < listadoEstudiantes.size(); i++) {
 * if (listadoEstudiantes.get(i).nota >= 6){
 * countAprobados += 1;
 * };
 * if (listadoEstudiantes.get(i).nota > notaMax){
 * notaMax = listadoEstudiantes.get(i).nota;
 * };
 * if (listadoEstudiantes.get(i).nota < notaMin) {
 * notaMin = listadoEstudiantes.get(i).nota;
 * };
 * //System.out.println("Nota N" + count + ": " + listadoEstudiantes.get(i));
 * sumNotas = sumNotas + listadoEstudiantes.get(i).nota;
 * };
 * promedio = (double) sumNotas / listadoEstudiantes.size();
 * countDesaprobados =listadoEstudiantes.size() - countAprobados;
 * generarInformeEstadistico(listadoEstudiantes, promedio, countAprobados,
 * countDesaprobados, notaMax, notaMin);
 * };
 * public static void mostrarNotasAprobadas(ArrayList<Estudiante>
 * listadoEstudiantes){
 * System.out.println("Listado aprobados");
 * System.out.println("Legajo");
 * for (int i = 0; i < listadoEstudiantes.size(); i++) {
 * if (listadoEstudiantes.get(i).nota >= 6){
 * System.out.println(listadoEstudiantes.get(i).legajo);
 * }
 * }
 * };
 * public static void main(String[] args) {
 * 
 * int nroPedido = 1;
 * ArrayList<Estudiante> listadoEstudiantes = new ArrayList<>();
 * 
 * Scanner miEscaner = new Scanner(System.in);
 * do {
 * mostrarMenu();
 * System.out.print("Seleccione una opcion: ");
 * nroPedido = miEscaner.nextInt();
 * 
 * if (nroPedido == 1) {
 * //System.out.println("Opcion Seleccionada: Cargar notas");
 * cargarEstudiantes(listadoEstudiantes, miEscaner);
 * }
 * 
 * else if (nroPedido == 2){
 * validarEstudiantesCargados(listadoEstudiantes, () ->
 * mostrarEstadistica(listadoEstudiantes));
 * 
 * }
 * 
 * else if (nroPedido == 3){
 * validarEstudiantesCargados(listadoEstudiantes, () ->
 * buscarEstudiante(listadoEstudiantes, miEscaner));
 * }
 * 
 * else if (nroPedido == 4){
 * //System.out.println("Opcion Seleccionada: Mostrar notas aprobadas");
 * validarEstudiantesCargados(listadoEstudiantes, () ->
 * mostrarNotasAprobadas(listadoEstudiantes));
 * };
 * 
 * } while (nroPedido != 0);
 * };
 * }
 */
