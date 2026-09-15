package com.joaco;

import com.joaco.objetos.Escuderia;
import com.joaco.objetos.Escuderias;

/**
 * Hello world!
 */
public class App {

    // Modificar el presupuesto a una escuderia
    // si existen eleentos a iterar oy obtener el mismo
    // si el leido es el borrado, entonces modificar el presupuesto

    public static void main(String[] args) {

        Escuderias coleccion = new Escuderias();

        for (int i = 0; i < coleccion.cantidadEscuderias(); i++) {

        }

        while (coleccion.haySiguiente()) {
        }
        // System.out.println("Hello World!");
    }
}
/**
 * # Manejo de Vectores, Iteradores y Colecciones
 * 
 * La Idea es presentar un programa que demuestre en forma incremental cual
 * seria la aproximacion para el uso de Iteradores y que eso nos lleve al manejo
 * de la API de las colecciones
 * 
 * ## Enunciado
 * 
 * La FIA necesita un programa que lleve un registro mínimo de las escuderias
 * que
 * participan en las distintas catagorias que regula. De esto se desprenden las
 * siguientes clases que se deben manejar
 * 
 * Por cada Escuderia se sabe:
 * - un código,
 * - un nombre,
 * - presupuesto en millones de dólares,
 * - categoria en la que corre.
 * 
 * Por cada Categoria se conoce
 * - codigo
 * - Descripcion
 * 
 * ## A Realizar
 * 
 * - Armado de clases para que simplemente manejen los datos
 * - Armado de una clase que permita manipular todas las escuderias que se
 * deseen cargar, como primera aproximación usaremos un Array y tendra los
 * siguientes comportamientos.
 * - add que agregue un nuevo elemento, prestando atencion a la redimension
 * - remove que quite un elemento
 * - Retornar un listado de todas las escuderias de una determinada categoria
 * - Retornar la categoria con el mayor presupuesto
 * 
 * ## Segunda Rosca
 * 
 * Dotar a la clase que contiene el Array la capacidad de poder ser iterada
 * implementando los siguientes comportamientos
 * - haySiguiente
 * - siguiente
 * - el remove ya esta implementado
 * 
 * ## Tercera Rosca
 * 
 * Implementar la capacidad de iteracion por fuera de la clase, armando un
 * patron Iterator. Usando las siguientes interfaces
 * 
 * ```JAVA
 * public interface Iterable
 * public interface Iterator
 * ```
 * 
 * ## Final
 * 
 * Implementar una nueva clase que meneje las escuderias, pero no usando un
 * Array sino usando una coleccion de la API provista por JAVA
 */