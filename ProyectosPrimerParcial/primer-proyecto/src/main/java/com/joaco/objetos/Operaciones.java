package com.joaco.objetos;

public class Operaciones {
    private Fraccionario primerFraccion;
    private Fraccionario segundaFraccion;

    public Operaciones(Fraccionario primerFraccion, Fraccionario segundaFraccion) {
        this.primerFraccion = primerFraccion;
        this.segundaFraccion = segundaFraccion;
    }

    public Fraccionario sumar() {
        int numerador = primerFraccion.getNumerador() * segundaFraccion.getDenominador()
                + (primerFraccion.getDenominador() * segundaFraccion.getNumerador());
        int denominador = primerFraccion.getDenominador() * segundaFraccion.getDenominador();
        return new Fraccionario(numerador, denominador);
    }

    public Fraccionario restar() {
        int numerador = primerFraccion.getNumerador() * segundaFraccion.getDenominador()
                - (primerFraccion.getDenominador() * segundaFraccion.getNumerador());
        int denominador = primerFraccion.getDenominador() * segundaFraccion.getDenominador();
        return new Fraccionario(numerador, denominador);
    }

    public Fraccionario multiplicar() {
        int numerador = primerFraccion.getNumerador() * segundaFraccion.getNumerador();
        int denominador = primerFraccion.getDenominador() * segundaFraccion.getDenominador();
        return new Fraccionario(numerador, denominador);
    }

    public Fraccionario dividir() {
        int numerador = primerFraccion.getNumerador() * segundaFraccion.getDenominador();
        int denominador = primerFraccion.getDenominador() * segundaFraccion.getNumerador();
        return new Fraccionario(numerador, denominador);
    }
}

/**
 * package com.joaco.objetos;
 * 
 * public class Operaciones {
 * private final Fraccionario primerFraccion;
 * private final Fraccionario segundaFraccion;
 * 
 * public Operaciones(Fraccionario primerFraccion, Fraccionario segundaFraccion)
 * {
 * this.primerFraccion = primerFraccion;
 * this.segundaFraccion = segundaFraccion;
 * }
 * 
 * public Fraccionario suma() {
 * int numerador = primerFraccion.getNumerador() *
 * segundaFraccion.getDenominador()
 * + segundaFraccion.getNumerador() * primerFraccion.getDenominador();
 * int denominador = primerFraccion.getDenominador() *
 * segundaFraccion.getDenominador();
 * return new Fraccionario(numerador, denominador);
 * }
 * 
 * public Fraccionario resta() {
 * int numerador = primerFraccion.getNumerador() *
 * segundaFraccion.getDenominador()
 * - segundaFraccion.getNumerador() * primerFraccion.getDenominador();
 * int denominador = primerFraccion.getDenominador() *
 * segundaFraccion.getDenominador();
 * return new Fraccionario(numerador, denominador);
 * }
 * 
 * public Fraccionario multiplicacion() {
 * return new Fraccionario(
 * primerFraccion.getNumerador() * segundaFraccion.getNumerador(),
 * primerFraccion.getDenominador() * segundaFraccion.getDenominador());
 * }
 * 
 * public Fraccionario division() {
 * if (segundaFraccion.getNumerador() == 0) {
 * throw new ArithmeticException("No se puede dividir por una fraccion igual a
 * cero");
 * }
 * 
 * return new Fraccionario(
 * primerFraccion.getNumerador() * segundaFraccion.getDenominador(),
 * primerFraccion.getDenominador() * segundaFraccion.getNumerador());
 * }
 * }
 */