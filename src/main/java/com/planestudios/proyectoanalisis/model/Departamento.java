package com.planestudios.proyectoanalisis.model;

import java.util.LinkedList;

public class Departamento{
private String nombre;
private LinkedList<Profesor> profesores;

    public Departamento(String nombre, LinkedList<Profesor> profesores) {
        this.nombre = nombre;
        this.profesores = profesores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
