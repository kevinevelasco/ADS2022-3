package com.planestudios.proyectoanalisis.controller;

import com.planestudios.proyectoanalisis.model.Estudiante;

public class ControlEstudiante {
    private Estudiante estudiante;
    public ControlEstudiante(Estudiante estudiante){
        this.estudiante = estudiante;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
}
