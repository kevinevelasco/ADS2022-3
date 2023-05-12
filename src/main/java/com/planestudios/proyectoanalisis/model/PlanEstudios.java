package com.planestudios.proyectoanalisis.model;

import java.util.LinkedList;
import java.util.List;

public class PlanEstudios {
    private List<Asignatura> asignaturas;
    private Departamento departamento;
    public PlanEstudios(Departamento departamento, List<Asignatura> asignaturas) {
        this.departamento = departamento;
        this.asignaturas = asignaturas;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public List<Asignatura> getAsignaturas(){
        return this.asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public Asignatura getAsignatura(String codigo_asignatura){
        for(Asignatura asig:this.asignaturas){
            if(asig.getCodigoAsignatura().equals(codigo_asignatura)){
                return asig;
            }
        }
        return null;
    }
}
