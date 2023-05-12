package com.planestudios.proyectoanalisis.controller;

import com.planestudios.proyectoanalisis.model.Asignatura;
import com.planestudios.proyectoanalisis.model.RegistroAcademico;
import com.planestudios.proyectoanalisis.view.Inicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControlPromedio {

    @FXML
    private Button Batras;

    @FXML
    private Label promedio_total;

    @FXML
    private Label ultimo_semestre;

    @FXML
    void go_back(ActionEvent event) {
        try {
            Inicio.showInicio();
        }catch(Exception e){}
    }

    @FXML
    void initialize() {
        this.ultimo_semestre.setText(String.valueOf(ControlEventos.getEstudiante().obtenerUltimoPromedio(ControlEventos.getPlanEstudios().getAsignaturas())));
        this.promedio_total.setText(String.valueOf(ControlEventos.getEstudiante().obtenerPromedio(ControlEventos.getPlanEstudios().getAsignaturas())));
    }

}