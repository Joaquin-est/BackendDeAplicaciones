package com.frc.utn.isi.backend.viajes.objetos;

public class Cliente {
    private String nombreEmpresa;
    private String cuit;

    public Cliente(String nombreEmpresa, String cuit) {
        this.nombreEmpresa = nombreEmpresa;
        this.cuit = cuit;
    }

    public String getCuit() {
        return cuit;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }
}
