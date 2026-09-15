/*
La FIA necesita un programa que lleve un registro mínimo de las escuderias que
participan en las distintas catagorias que regula. De esto se desprenden 
las siguientes clases que se deben manejar

Por cada Escuderia se sabe:
- un código,
- un nombre,  
- presupuesto en millones de dólares,
- categoria en la que corre.

Por cada Categoria se conoce
- codigo
- Descripcion*/

package com.joaco.objetos;

public class Escuderia {
    private int codigo;
    private String nombre;
    private double presupuesto;
    private Object categoria;

    public Escuderia(int codigo, String nombre, double presupuesto, Object categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.categoria = categoria;
    }

    public Object getCategoria() {
        return this.categoria;
    }

    public String getNombre() {
        return this.nombre;
    }

    public double getPresupuesto() {
        return this.presupuesto;
    }
}

// Se utiliza el objeto Stringbuilder para poder imprimir secuencia de strings
// sin la necesidad que deba armar la secuencia como nuevo objeto en memoria y
// que deba eliminarse automaticamente (proceso ejecutado por JVM)

// pacakge: es lo que se conoce en python como modulo
