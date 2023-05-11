package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import modelo.CuatroRespApplication;
import modelo.Transformar;

import java.io.IOException;
import java.util.ArrayList;

public class CuatroRespControl {

    private Stage stage;
    private int numeroPregunta=1;

    @FXML
    private Button button;


    @FXML
    private RadioButton idOpcion1;

    @FXML
    private RadioButton idOpcion2;

    @FXML
    private RadioButton idOpcion3;

    @FXML
    private RadioButton idOpcion4;

    @FXML
    private ToggleGroup optionsGroup;

    @FXML
    private Label preguntaid;

    @FXML
    public void mostrarPregunta(ActionEvent event) throws ClassNotFoundException {

    }
    @FXML
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException, IOException {
        numeroPregunta--;
        startController();
    }

    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException, IOException {
        numeroPregunta++;
        ArrayList<String> listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));

        switch (Integer.parseInt(listaResult.get(0))) {
            case 1:
                startController();
                break;
            case 2:

                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(getClass().getResource("login-view.fxml"));
                Parent root = loader.load();
                DosOpcionesControl Hellocontrollerf= loader.getController();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                startController();

                break;
            case 3:
                break;
            default:
                break;
        }

    }

    public  void startController() throws ClassNotFoundException, IOException {

        ArrayList<String> listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));

        preguntaid.setText(listaResult.get(0));
        idOpcion1.setText(listaResult.get(1));
        idOpcion2.setText(listaResult.get(2));
        idOpcion3.setText(listaResult.get(3));
        idOpcion4.setText(listaResult.get(4));

    }
   /* public  void startController() throws ClassNotFoundException {

        ArrayList<String> listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));

        switch (Integer.parseInt(listaResult.get(0))) {
            case 1:
                preguntaid.setText(listaResult.get(0));
                idOpcion1.setText(listaResult.get(1));
                idOpcion2.setText(listaResult.get(2));
                idOpcion3.setText(listaResult.get(3));
                idOpcion4.setText(listaResult.get(4));
                break;
            case 2:
                //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

                break;
            case 3:
                break;
            default:
                break;
        }


    }

*/
}