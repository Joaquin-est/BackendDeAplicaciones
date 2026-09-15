package com.objetos;

public class Mascota {
    private String nombre;
    private int energia;
    private int humor;
    private String estado = "Despierto";
    private String vivo = "Vivo";

    // Constructor
    public Mascota(String nombre, int energia, int humor) {
        this.nombre = nombre;
        this.energia = energia;
        this.humor = humor;
    }

    // Comportamientos de ingesta
    public void comer(int valor) {
        if (valor >= 5) {
            this.vivo = "Muerto";
        } else {
            if (this.energia <= 90) {
                if (valor < 3) {
                    this.energia += 10;
                } else {
                    if (this.humor >= 1) {
                        this.humor -= 1;
                        if (this.humor == 0) {
                            this.dormir();
                        }
                    }
                }
            }
            if (this.humor < 5) {
                this.humor += 1;
            }
        }
    }

    public void beber(int valor) {
        if (valor >= 5) {
            this.vivo = "Muerto";
        } else {
            if (this.energia <= 95) {
                this.energia += 5;
                if (valor >= 3) {
                    if (this.humor <= 1) {
                        this.humor -= 1;
                    }
                    if (this.humor == 0) {
                        this.dormir();
                    }
                }
            }
            if (this.humor < 5) {
                this.humor += 1;
            }
        }
    }

    // Comportamientos de actividades
    public void correr(int valor) {
        if (valor == 3) {
            this.dormir();
        }
        if (this.energia >= 35) {
            this.energia -= 35;
        } else {
        }
        if (this.humor >= 2) {
            this.humor -= 2;
            if (this.humor == 0) {
                this.dormir();
            }
        } else {
        }
    }

    public void saltar(int valor) {
        if (valor == 3) {
            this.dormir();
        }
        if (this.energia >= 15) {
            this.energia -= 15;
        }
        if (this.humor >= 2) {
            this.humor -= 2;
            if (this.humor == 0) {
                this.dormir();
            }
        }
    }

    // Otros comportamientos
    public void dormir() {
        this.estado = "Durmiendo";
        if (this.energia <= 75) {
            this.energia += 25;
        }
        if (this.humor <= 3) {
            this.humor += 2;
        }
    }

    public void despertar() {
        this.estado = "Despertar";
    }

    public Boolean estavivo() {
        if (this.energia == 0) {
            this.vivo = "Muerto";
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\n" +
                "Energia: " + this.energia + "\n" +
                "Humor: " + this.humor + "\n" +
                "Vive: " + this.vivo + "\n" +
                "Estado: " + this.estado;
    }
}
