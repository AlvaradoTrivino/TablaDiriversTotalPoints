package project.repositorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import project.model.Conexion;
import project.model.DriverMaxPoint;

public class DriversPoints2 {
    
    public List<DriverMaxPoint> getDriversMaxPoints() {
        List<DriverMaxPoint> results = new ArrayList<>();
        
        String sql = "SELECT " +
                     "    d.forename || ' ' || d.surname AS driver_name, " +
                     "    SUM(r.points) AS total_points " +
                     "FROM " +
                     "    results r " +
                     "JOIN " +
                     "    drivers d ON r.driver_id = d.driver_id " +
                     "GROUP BY " +
                     "    d.forename, d.surname " +
                     "ORDER BY " +
                     "    total_points DESC " +
                     "LIMIT 50;";
        
        try {
            // Establecer la conexión
            Conexion dbConexion = new Conexion();
            Connection conn = dbConexion.EstablecerConexion("bd_pruebas", "postgres", "12345", "postgresql");
            
            // Crear una sentencia
            PreparedStatement statement = conn.prepareStatement(sql);
            
            ResultSet rs = statement.executeQuery();
            
            // Procesar los resultados
            while (rs.next()) {
                String driverName = rs.getString("driver_name");
                float points = rs.getFloat("total_points");
                
                DriverMaxPoint result = new DriverMaxPoint(driverName, points);
                results.add(result);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return results;
    }
    
    public static void main(String[] args) {
        DriversPoints2 driversPointsRepository = new DriversPoints2();
        List<DriverMaxPoint> driverList = driversPointsRepository.getDriversMaxPoints();
        
        // Imprimir encabezado de la tabla
        System.out.printf("%-20s %-10s%n", "Driver Name", "Total Points");
        
        // Imprimir cada registro con formato
        for (DriverMaxPoint driver : driverList) {
            System.out.printf("%-20s %-10.2f%n", driver.getDriverName(), driver.getPoints());
        }
    }
}
