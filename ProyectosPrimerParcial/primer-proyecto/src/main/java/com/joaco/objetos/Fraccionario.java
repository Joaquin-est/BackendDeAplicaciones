package com.joaco.objetos;

public class Fraccionario {
    private int numerador;
    private int denominador;

    // Constructor (no se ingresa tipo de dato)
    public Fraccionario() {
        numerador = 0;
        denominador = 0;
    }

    public Fraccionario(int num, int den) {
        numerador = num;
        denominador = den;
    }

    public void setNumerador(int num) {
        numerador = num;
    }

    public void setDenominador(int den) {
        denominador = den;
    }

    public int getNumerador() {
        return numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    // El Override es un "Decorador", decide ingorar todo lo que se encuentra sobre
    // el mismo
    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}

// En este punto yo les doy 30 minutos para hacer las operaciones de Suma,
// Resta, Multiplicacion y division.