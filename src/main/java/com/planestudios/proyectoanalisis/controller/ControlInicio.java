package com.planestudios.proyectoanalisis.controller;

import com.planestudios.proyectoanalisis.model.Estudiante;
import com.planestudios.proyectoanalisis.view.Inicio;
import com.planestudios.proyectoanalisis.view.Promedio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ControlInicio {
    @FXML
    private Label nombre_estudiante;
    @FXML
    private Button Bmaterias;

    @FXML
    private Button Bpromedio;

    @FXML
    void ver_pensum(ActionEvent event) {
        try {
            Inicio.showPensum();
        }catch(Exception e){}
    }

    @FXML
    void ver_promedio(ActionEvent event) {
        Promedio.show();
    }

    @FXML
    void initialize() {
        nombre_estudiante.setText(Inicio.getNombreEstudiante());
    }
}