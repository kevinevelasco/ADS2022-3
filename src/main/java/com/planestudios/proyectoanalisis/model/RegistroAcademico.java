package com.planestudios.proyectoanalisis.model;

public class RegistroAcademico {
    private Float nota;
    private Clase clase;

    public RegistroAcademico(Float nota, Clase clase) {
        this.nota = nota;
        this.clase = clase;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    @Override
    public String toString() {
        return "RegistroAcademico{" +
                "nota=" + nota +
                ", clase=" + clase +
                '}';
    }
}
