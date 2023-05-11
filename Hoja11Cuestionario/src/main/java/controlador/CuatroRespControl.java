package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import modelo.Transformar;

import java.util.ArrayList;

public class CuatroRespControl {

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
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException {
        numeroPregunta--;
        startController();
    }

    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException {
        numeroPregunta++;
        startController();
    }

    public  void startController() throws ClassNotFoundException {

        ArrayList<String> listaResult = ContolBD.hacerArrayPregunta(Transformar.selectRs4(numeroPregunta));

        preguntaid.setText(listaResult.get(0));
        idOpcion1.setText(listaResult.get(1));
        idOpcion2.setText(listaResult.get(2));
        idOpcion3.setText(listaResult.get(3));
        idOpcion4.setText(listaResult.get(4));

    }


}