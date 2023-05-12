package com.planestudios.proyectoanalisis.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlanDeEstudios {
    public static void show(){
        try {
            Inicio.showPensum();
        }catch(Exception e){}
    }


}