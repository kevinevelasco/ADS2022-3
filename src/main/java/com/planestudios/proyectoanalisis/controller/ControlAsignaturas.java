package com.planestudios.proyectoanalisis.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.planestudios.proyectoanalisis.model.Asignatura;
import com.planestudios.proyectoanalisis.model.RegistroAcademico;
import com.planestudios.proyectoanalisis.view.InfoMateria;
import com.planestudios.proyectoanalisis.view.Inicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControlAsignaturas {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label label_cod_materia;

    @FXML
    private Label label_nombre_clase;

    @FXML
    private Label label_nota;

    @FXML
    private Label label_periodo_academico;

    @FXML
    private Label label_profesor;

    @FXML
    private Label label_tipo_credito;

    @FXML
    void go_back(ActionEvent event) {
        try {
            Inicio.showPensum();
        }catch(Exception e){}
    }

    @FXML
    void initialize() {
        Asignatura asig = ControlEventos.getPlanEstudios().getAsignatura(ControlEventos.asignatura);
        RegistroAcademico reg = ControlEventos.getEstudiante().obtenerInfoClase(asig);
        this.label_nombre_clase.setText(asig.getNombre());
        this.label_profesor.setText("");
        this.label_cod_materia.setText("");
        this.label_tipo_credito.setText(asig.getTipoDeArea());
        this.label_nota.setText("");
        this.label_periodo_academico.setText("");
        if(reg!=null){
            this.label_profesor.setText(reg.getClase().getProfesor().getNombre()+" "+reg.getClase().getProfesor().getApellido());
            this.label_cod_materia.setText(reg.getClase().getCodigoClase());
            this.label_nota.setText(reg.getNota().toString());
            this.label_periodo_academico.setText(reg.getClase().getAnio().toString()+" "+reg.getClase().getPeriodoAcademico().toString());
        }
    }

}
