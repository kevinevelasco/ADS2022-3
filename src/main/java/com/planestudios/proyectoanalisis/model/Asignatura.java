package com.planestudios.proyectoanalisis.model;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
    private String codigoAsignatura;
    private String nombre;
    private String tipoDeArea;
    private Integer numeroCreditos;
    private List<Clase> clases = new ArrayList<>();
    private List <Asignatura> prerequisitos = new ArrayList<>();
    private List<Asignatura> corequisitos = new ArrayList<>();
    public Asignatura(String codigoAsignatura, String nombre, String tipoDeCredito, Integer numeroCreditos) {
        this.codigoAsignatura = codigoAsignatura;
        this.nombre = nombre;
        this.tipoDeArea = tipoDeCredito;
        this.numeroCreditos = numeroCreditos;
    }
    public Asignatura(){}

    public void prerequerimientos(Asignatura prerequisito){
   prerequisitos.add(prerequisito);
    }
    public void coprerequerimientos(Asignatura corequisito){
        corequisitos.add(corequisito);

    }
    public void agregarClase (Clase clase){
        clases.add(clase);
    }

    public String getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(String codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoDeCredito() {
        return tipoDeArea;
    }

    public void setTipoDeCredito(String tipoDeCredito) {
        this.tipoDeArea= tipoDeCredito;
    }

    public Integer getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(Integer numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Asignatura> getPrerequisitos() {
        return prerequisitos;
    }

    public void setPrerequisitos(List<Asignatura> prerequisitos) {
        this.prerequisitos = prerequisitos;
    }

    public List<Asignatura> getCorequisitos() {
        return corequisitos;
    }

    public void setCorequisitos(List<Asignatura> corequisitos) {
        this.corequisitos = corequisitos;
    }

    public String getTipoDeArea() {
        return tipoDeArea;
    }

    public void setTipoDeArea(String tipoDeArea) {
        this.tipoDeArea = tipoDeArea;
    }



}
