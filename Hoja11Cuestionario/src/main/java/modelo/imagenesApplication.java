package modelo;


import controlador.ImagenesControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class imagenesApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(imagenesApplication.class.getResource("imagenes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");

        ImagenesControl controller = fxmlLoader.getController();
        controller.startController();
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ClassNotFoundException {

       // ContolBD.ejecutar(Transformar.insertPregunta1(1,"Elige una profesión:","Actor","p_andy",4));




        launch();
    }
}