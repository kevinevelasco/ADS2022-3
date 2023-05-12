package com.planestudios.proyectoanalisis.view;

import com.planestudios.proyectoanalisis.controller.ControlEstudiante;
import com.planestudios.proyectoanalisis.controller.ControlEventos;
import com.planestudios.proyectoanalisis.controller.ControlPlanEstudios;
import com.planestudios.proyectoanalisis.model.Departamento;
import com.planestudios.proyectoanalisis.model.Estudiante;
import com.planestudios.proyectoanalisis.model.ManejadorArchivos;
import com.planestudios.proyectoanalisis.model.PlanEstudios;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Inicio extends Application{
    private static FXMLLoader fxmlLoader;
    private static FXMLLoader fxmlLoaderPensum;
    private static FXMLLoader fxmlLoaderInfoMaterias;
    private static FXMLLoader fxmlLoaderPromedio;
    private static FXMLLoader fxmlLoaderInicio;
    private static Estudiante estudiante;
    private static Stage stage_principal;
    @Override
    public void start(Stage stage) throws IOException {
        ManejadorArchivos ma = new ManejadorArchivos();
        ma.leerAsignaturas();
        ma.leerClases();
        ma.leerProfesores();
        ma.leerRegistroAcademico();
        ControlEstudiante controlE = new ControlEstudiante(ma.asignarRegistro());
        ControlEventos.setControlEstudiante(controlE);
        estudiante = ma.asignarRegistro();
        Departamento departamento = new Departamento("Sistemas",null);
        PlanEstudios planE = new PlanEstudios(departamento, ma.getAsignaturas());
        ControlPlanEstudios controlP = new ControlPlanEstudios(planE);
        ControlEventos.setControlPlanEstudios(controlP);
        stage_principal = stage;
        showInicio();
    }
    public static void showInicio() throws IOException{
        fxmlLoaderInicio = new FXMLLoader(PlanDeEstudios.class.getResource("inicio.fxml"));
        Scene scene = new Scene(fxmlLoaderInicio.load());
        stage_principal.setTitle("ProyectoADS");
        stage_principal.setScene(scene);
        stage_principal.show();
    }
    public static void showPensum() throws IOException{
        fxmlLoaderPensum = new FXMLLoader(PlanDeEstudios.class.getResource("planDeEstudios.fxml"));
        Scene scene = new Scene(fxmlLoaderPensum.load());
        stage_principal.setTitle("ProyectoADS");
        stage_principal.setScene(scene);
        stage_principal.show();
    }
    public static void showPromedio() throws IOException{
        fxmlLoaderPromedio = new FXMLLoader(PlanDeEstudios.class.getResource("promedio.fxml"));
        Scene scene = new Scene(fxmlLoaderPromedio.load());
        fxmlLoaderPromedio.getController();
        stage_principal.setTitle("ProyectoADS");
        stage_principal.setScene(scene);
        stage_principal.show();
    }
    public static void showInfoMateria() throws IOException{
        fxmlLoaderInfoMaterias = new FXMLLoader(PlanDeEstudios.class.getResource("info_materia.fxml"));
        Scene scene = new Scene(fxmlLoaderInfoMaterias.load());
        fxmlLoaderInfoMaterias.getController();
        stage_principal.setTitle("ProyectoADS");
        stage_principal.setScene(scene);
        stage_principal.show();
    }
    public static String getNombreEstudiante(){
        return estudiante.getNombre()+" "+estudiante.getApellido();
    }
    public static void main(String[] args) {
        launch();
    }
}
