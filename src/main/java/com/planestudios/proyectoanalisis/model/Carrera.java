package com.planestudios.proyectoanalisis.model;

public class Carrera {
    private String nombreCarrera;
    private String tipoPrograma;

    public Carrera(String nombreCarrera, String tipoPrograma) {
        this.nombreCarrera = nombreCarrera;
        this.tipoPrograma = tipoPrograma;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public String getTipoPrograma() {
        return tipoPrograma;
    }

    public void setTipoPrograma(String tipoPrograma) {
        this.tipoPrograma = tipoPrograma;
    }
}
