package com.planestudios.proyectoanalisis.model;

import java.util.ArrayList;
import java.util.List;

public class Clase {
    private String codigoClase;
    private String nombre;
    private Integer cupo;
    private Integer anio;
    private Integer periodoAcademico;

    private List<Profesor> profesores = new ArrayList<>();

    public Clase(String codigoClase, String nombre, Integer cupo, Integer anio, Integer periodoAcademico) {
        this.codigoClase = codigoClase;
        this.nombre = nombre;
        this.cupo = cupo;
        this.anio = anio;
        this.periodoAcademico = periodoAcademico;
    }

    public void agregarProfesor(Profesor profesor){
        profesores.add(profesor);
    }

    public String getCodigoClase() {
        return codigoClase;
    }

    public void setCodigoClase(String codigoClase) {
        this.codigoClase = codigoClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(Integer periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }
    public Profesor getProfesor(){
        return profesores.get(0);
    }
}
