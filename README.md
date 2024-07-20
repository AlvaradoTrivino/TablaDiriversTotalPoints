## Presentacion de la Tabla Drivers con el total de los puntos
![Captura de pantalla (228)](https://github.com/user-attachments/assets/0740a7f1-8614-4f3d-a608-eba1e68aaea5)

## Project Structure
Driver Points Management System
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── project
│   │   │   │   ├── App.java                  
│   │   │   │   ├── controller
│   │   │   │   │   └── TotalPointsDrivers.java
│   │   │   │   ├── model
│   │   │   │   │   ├── Conexion.java          
│   │   │   │   │   └── DriverMaxPoint.java    
│   │   │   │   └── repositorio
│   │   │   │       └── DriversPoints2.java  
│   │   │   └── module-info.java             
│   │   └── resources
│   │       └── project
│   │           └── view
│   │               └── fxml
│   │                   └── tablaDriversPoints.fxml   
└── README.md   

## Funciones
Mostrar puntos de controlador:
Muestra una lista de conductores junto con su total de puntos.
Integración de bases de datos: 
Se conecta a una base de datos PostgreSQL para recuperar datos de puntos de controlador.
Arquitectura MVC: 
Sigue el patrón de diseño Modelo-Vista-Controlador (MVC) para una clara separación de las preocupaciones.

## Estructura del Proyecto
TotalPointsDrivers.java: Controlador JavaFX que configura y carga la tabla de puntos de conductores desde el repositorio.
Conexion.java: Clase para establecer la conexión a la base de datos (MySQL o PostgreSQL).
DriverMaxPoint.java: Modelo que representa los datos de puntos de un conductor.
DriversPoints2.java: Repositorio que obtiene los puntos de los conductores desde la base de datos utilizando una consulta SQL.
App.java: Clase principal que inicia la aplicación JavaFX y carga la interfaz FXML.
module-info.java: Configuración del módulo que especifica las dependencias y las exportaciones necesarias.

