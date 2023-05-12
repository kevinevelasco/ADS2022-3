module com.planestudios.proyectoanalisis {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.csv;
    requires org.apache.commons.io;


    opens com.planestudios.proyectoanalisis to javafx.fxml;
    exports com.planestudios.proyectoanalisis;
    opens com.planestudios.proyectoanalisis.controller to javafx.fxml;
    exports  com.planestudios.proyectoanalisis.controller;
    exports com.planestudios.proyectoanalisis.view;
    opens com.planestudios.proyectoanalisis.view to javafx.fxml;
}