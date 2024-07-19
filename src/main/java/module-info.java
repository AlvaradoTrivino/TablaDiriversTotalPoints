module project.model {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens project.controller to javafx.fxml;
    opens project to javafx.fxml; // Si tienes otros paquetes que también necesitan acceso a FXML

    exports project.controller;
    exports project;
    opens project.model to javafx.base;
}