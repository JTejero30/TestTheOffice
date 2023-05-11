package modelo;

import controlador.DosOpcionesControl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DosOpcionesApplication extends Application {
        @Override
        public void start(Stage stage) throws IOException, ClassNotFoundException {

            FXMLLoader fxmlLoader = new FXMLLoader(modelo.DosOpcionesApplication.class.getResource("dos-opciones-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Hello!");

            DosOpcionesControl controller = fxmlLoader.getController();
            controller.startController();

            stage.setScene(scene);
            stage.show();



        }

        public static void main(String[] args) throws ClassNotFoundException {

            // ContolBD.ejecutar(Transformar.insertPregunta1(1,"Elige una profesión:","Actor","p_andy",4));

            launch();
        }

        /*public static void comprobarTipo(int tipo_pregunta){

            String vista="";

            switch (tipo_pregunta){
                case 1:
                    vista="cuatro-resp-view";
                    break;
                case 2:
                    vista="dos-opciones-view";
                    break;
                case 3:
                    break;
                case 4:
                    break;
            }


        }*/

}
