package com.joaco.objetos;

public class Cliente {
    private int codigo;
    protected String nombre;
    protected double saldo;
    protected int nivelCrediticio;

    public Cliente(int codigo, String nombre, double saldo, int nivelCrediticio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.saldo = saldo;
        this.nivelCrediticio = nivelCrediticio;
    }

    public enum NivelCrediticio {
        MOROSO, // ordinal 0
        BRONCE, // ordinal 1
        PLATA, // ordinal 2
        ORO // ordinal 3
    }
    // El enum es decirle decirle que valor tiene ese numero

    public modificarSaldo(double saldo){
        if (saldo > 0 ){
            this.saldo += saldo;
        }
        else if (saldo < 0){
            this.saldo -= saldo;
        }
    }

    public modificarNivelCrediticio(){
        if (this.saldo < 0){
            this.nivelCrediticio = 0;
        }
        else {
            if (this.saldo < 300000){
                this.nivelCrediticio = 1;
            }
            else if (1000000 > this.saldo  && this.saldo >= 300000){
                this.nivelCrediticio = 2; 
            }
            else {
                this.nivelCrediticio = 3;
            }
        }
    }
}
