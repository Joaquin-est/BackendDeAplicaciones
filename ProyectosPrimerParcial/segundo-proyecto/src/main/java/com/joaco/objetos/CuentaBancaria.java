package com.joaco.objetos;

public class CuentaBancaria {
    private String titular;
    private int nroCuenta;
    private double saldo;

    public CuentaBancaria(String titular, int nroCuenta, double saldo) {
        this.titular = titular;
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public CuentaBancaria() {
        this.titular = null;
        this.nroCuenta = 0;
        this.saldo = 0;
    }

    public String getTitular() {
        return this.titular;
    }

    public int getNroCuenta() {
        return this.nroCuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void cargarSaldo(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    public boolean extraerDinero(double saldo) {
        if (this.saldo < saldo) {
            this.saldo = this.saldo - saldo;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return this.titular + this.nroCuenta + this.saldo;
    }
}
