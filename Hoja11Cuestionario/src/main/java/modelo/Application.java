package modelo;

import controlador.Controlador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {

        FXMLLoader fxmlLoader = new FXMLLoader(modelo.Application.class.getResource("dos-opciones-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");

        Controlador controller = fxmlLoader.getController();
        controller.randomInterval();
        controller.startController();

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws ClassNotFoundException {

        launch();
    }
}
