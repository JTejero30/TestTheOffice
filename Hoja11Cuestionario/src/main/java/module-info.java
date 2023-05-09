module com.example.hoja11cuestionario {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;

    opens com.example.hoja11cuestionario to javafx.fxml;
    exports com.example.hoja11cuestionario;
}