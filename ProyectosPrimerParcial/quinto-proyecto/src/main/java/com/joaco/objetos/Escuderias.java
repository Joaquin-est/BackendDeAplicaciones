package com.joaco.objetos;

import java.util.Iterator;

public class Escuderias implements Iterable<Object> {
    private Object[] item;
    private int cantidad;
    private int indice;

    public Escuderias() {
        this.item = new Object[10];
        this.cantidad = 0;
        this.indice = 0;
    }

    public Escuderias(int capacity) {
        this.item = new Object[capacity];
        this.cantidad = 0;
        this.indice = 0;
    }

    // Agregar un elemento (Object) a la colección
    public void agregar(Object elemento) {
        if (this.cantidad < this.item.length) {
            this.item[this.cantidad] = elemento;
            this.cantidad++;
        }
    }

    // Agregar una escudería a la lista (mantiene compatibilidad)
    public void agregarEscuderia(Escuderia escuderia) {
        this.agregar(escuderia);
    }

    // Implementar el método iterator para hacer la clase Iterable
    @Override
    public Iterator<Object> iterator() {
        return new EscuderiasIterator(this);
    }

    // Obtener la cantidad de elementos
    public int cantidadEscuderias() {
        return this.cantidad;
    }

    public int size() {
        return this.cantidad;
    }

    // Determinar si la colección se encuentra vacía
    public boolean isEmpty() {
        return this.cantidad == 0;
    }

    // Verificar si hay siguiente elemento
    public boolean haySiguiente() {
        return this.indice < this.cantidad;
    }

    // Obtener el siguiente elemento
    public Object siguiente() {
        if (haySiguiente()) {
            return this.item[this.indice++];
        }
        return null;
    }

    // Reiniciar el iterador
    public void reiniciarIterador() {
        this.indice = 0;
    }

    // Obtener elemento en posición específica
    public Object get(int i) {
        if (i >= 0 && i < this.cantidad) {
            return this.item[i];
        }
        return null;
    }

    // Remover un elemento en posición específica
    public Object remove(int i) {
        if (i >= 0 && i < this.cantidad) {
            Object elemento = this.item[i];
            // Desplazar elementos hacia la izquierda
            for (int j = i; j < this.cantidad - 1; j++) {
                this.item[j] = this.item[j + 1];
            }
            this.item[this.cantidad - 1] = null;
            this.cantidad--;
            return elemento;
        }
        return null;
    }

    // Clase interna para Iterator
    private class EscuderiasIterator implements Iterator<Object> {
        private int iterIndice = 0;
        private Escuderias escuderias;

        public EscuderiasIterator(Escuderias escuderias) {
            this.escuderias = escuderias;
        }

        @Override
        public boolean hasNext() {
            return this.iterIndice < this.escuderias.cantidad;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return this.escuderias.item[this.iterIndice++];
            }
            return null;
        }
    }
}
