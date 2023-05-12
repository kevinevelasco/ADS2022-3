package com.planestudios.proyectoanalisis.controller;

import com.planestudios.proyectoanalisis.model.Asignatura;
import com.planestudios.proyectoanalisis.model.Estudiante;
import com.planestudios.proyectoanalisis.model.PlanEstudios;
import com.planestudios.proyectoanalisis.model.RegistroAcademico;
import com.planestudios.proyectoanalisis.view.InfoMateria;
import com.planestudios.proyectoanalisis.view.Inicio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlEventos {
    protected static ControlEstudiante c_estudiante;
    protected static ControlPlanEstudios c_planEstudios;
    public static String asignatura;
    public static void setControlEstudiante(ControlEstudiante c_estudiante){
        ControlEventos.c_estudiante = c_estudiante;
    }
    public static void setControlPlanEstudios(ControlPlanEstudios c_planEstudios){
        ControlEventos.c_planEstudios = c_planEstudios;
    }
    public static PlanEstudios getPlanEstudios(){
        return c_planEstudios.getPlanEstudios();
    }
    public static Estudiante getEstudiante(){
        return c_estudiante.getEstudiante();
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button B1290;

    @FXML
    private Button B1291;

    @FXML
    private Button B1295;

    @FXML
    private Button B1297;

    @FXML
    private Button B1299;

    @FXML
    private Button B1300;

    @FXML
    private Button B1340;

    @FXML
    private Button B16143;

    @FXML
    private Button B22586;

    @FXML
    private Button B2356;

    @FXML
    private Button B2476;

    @FXML
    private Button B2544;

    @FXML
    private Button B31339;

    @FXML
    private Button B3194;

    @FXML
    private Button B33578;

    @FXML
    private Button B33698;

    @FXML
    private Button B33699;

    @FXML
    private Button B33700;

    @FXML
    private Button B33732;

    @FXML
    private Button B33733;

    @FXML
    private Button B33763;

    @FXML
    private Button B34580;

    @FXML
    private Button B34801;

    @FXML
    private Button B34802;

    @FXML
    private Button B34803;

    @FXML
    private Button B34804;

    @FXML
    private Button B34805;

    @FXML
    private Button B34806;

    @FXML
    private Button B34807;

    @FXML
    private Button B34808;

    @FXML
    private Button B34809;

    @FXML
    private Button B34810;

    @FXML
    private Button B34814;

    @FXML
    private Button B34816;

    @FXML
    private Button B34863;

    @FXML
    private Button B34866;

    @FXML
    private Button B4075;

    @FXML
    private Button B4082;

    @FXML
    private Button B4084;

    @FXML
    private Button B4085;

    @FXML
    private Button B4185;

    @FXML
    private Button B4190;

    @FXML
    private Button B4196;

    @FXML
    private Button B5100;

    @FXML
    private Button Batras;

    @FXML
    private Button Bcomplementaria1;

    @FXML
    private Button Bcomplementaria2;

    @FXML
    private Button Belectiva1;

    @FXML
    private Button Belectiva2;

    @FXML
    private Button Belectiva3;

    @FXML
    private Button Benfasis1;

    @FXML
    private Button Benfasis2;

    @FXML
    void go_back(ActionEvent event) {
        try {
            Inicio.showInicio();
        }catch(Exception e){}
    }

    @FXML
    void show1290(ActionEvent event) {
        showInfoAsignatura("1290");
    }

    @FXML
    void show1295(ActionEvent event) {
        showInfoAsignatura("1295");
    }

    @FXML
    void show1297(ActionEvent event) {
        showInfoAsignatura("1297");
    }

    @FXML
    void show2356(ActionEvent event) {
        showInfoAsignatura("2356");
    }

    @FXML
    void show2544(ActionEvent event) {
        showInfoAsignatura("2544");
    }

    @FXML
    void show33518(ActionEvent event) {
        showInfoAsignatura("33518");
    }

    @FXML
    void show33698(ActionEvent event) {
        showInfoAsignatura("33698");
    }

    @FXML
    void show33699(ActionEvent event) {
        showInfoAsignatura("33699");
    }

    @FXML
    void show33700(ActionEvent event) {
        showInfoAsignatura("33700");
    }

    @FXML
    void show33732(ActionEvent event) {
        showInfoAsignatura("33732");
    }

    @FXML
    void show33733(ActionEvent event) {
        showInfoAsignatura("33733");
    }

    @FXML
    void show33763(ActionEvent event) {
        showInfoAsignatura("33763");
    }

    @FXML
    void show34580(ActionEvent event) {
        showInfoAsignatura("34580");
    }

    @FXML
    void show34803(ActionEvent event) {
        showInfoAsignatura("34803");
    }

    @FXML
    void show34805(ActionEvent event) {
        showInfoAsignatura("34805");
    }

    @FXML
    void show34806(ActionEvent event) {
        showInfoAsignatura("34806");
    }

    @FXML
    void show34809(ActionEvent event) {
        showInfoAsignatura("34809");

    }

    @FXML
    void show34816(ActionEvent event) {
        showInfoAsignatura("34816");
    }

    @FXML
    void show4075(ActionEvent event) {
        showInfoAsignatura("4075");
    }

    @FXML
    void show4082(ActionEvent event) {
        showInfoAsignatura("4082");
    }

    @FXML
    void show4085(ActionEvent event) {
        showInfoAsignatura("4085");
    }

    @FXML
    void show4190(ActionEvent event) {
        showInfoAsignatura("4190");
    }

    @FXML
    void show4196(ActionEvent event) {
        showInfoAsignatura("4196");
    }

    public void showInfoAsignatura(String codigo_asignatura){
        asignatura = codigo_asignatura;
        InfoMateria.show();
    }
    @FXML
    void initialize() {

    }

}
