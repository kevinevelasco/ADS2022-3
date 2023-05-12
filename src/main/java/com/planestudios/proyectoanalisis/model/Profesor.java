package com.planestudios.proyectoanalisis.model;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private String nombre;
    private String apellido;
    private String id;
    private String numeroDocumento;
    private String tipoProfesor;

    private List<Clase> clasesDictar = new ArrayList<>();

    public Profesor(String nombre, String apellido, String id, String numeroDocumento, String tipoProfesor) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.numeroDocumento = numeroDocumento;
        this.tipoProfesor = tipoProfesor;
    }

    public String getNombre() {
        return nombre;
    }
    public void agregarClase(Clase clase){
            clasesDictar.add(clase);
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public void setTipoProfesor(String tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }
}
