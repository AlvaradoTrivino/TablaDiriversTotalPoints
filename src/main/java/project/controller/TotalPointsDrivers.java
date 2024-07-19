package project.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import project.model.DriverMaxPoint;
import project.repositorio.DriversPoints2;

public class TotalPointsDrivers implements Initializable {

    @FXML
    private TableColumn<DriverMaxPoint, String> NombreDriversPoints;

    @FXML
    private TableColumn<DriverMaxPoint, Float> TotalDriversPoints;

    @FXML
    private TableView<DriverMaxPoint> tablaDriversPoints;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Configurar las columnas de la tabla
        NombreDriversPoints.setCellValueFactory(new PropertyValueFactory<>("driverName"));
        TotalDriversPoints.setCellValueFactory(new PropertyValueFactory<>("points"));

        // Cargar los datos en la tabla
        loadDriversData();
    }

    private void loadDriversData() {
        DriversPoints2 driversPointsRepository = new DriversPoints2();
        List<DriverMaxPoint> driverList = driversPointsRepository.getDriversMaxPoints();

        // Limpiar la tabla antes de agregar nuevos datos
        if (tablaDriversPoints != null) {
            tablaDriversPoints.getItems().clear();
            // Agregar los datos a la tabla
            tablaDriversPoints.getItems().addAll(driverList);
        }
    }
}
