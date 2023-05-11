module com.example.hoja11cuestionario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens modelo to javafx.fxml;
    exports modelo;
    exports controlador;
    opens controlador to javafx.fxml;
}