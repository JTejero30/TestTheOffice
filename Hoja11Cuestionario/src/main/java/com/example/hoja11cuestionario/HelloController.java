package com.example.hoja11cuestionario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;

public class HelloController {

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
        numeroPregunta++;
        ArrayList<String> listaResult = ContolBD.pintarPreguntas4(Transformar.selectRs4(numeroPregunta));

        // RadioButton selectedToogle = (RadioButton) optionsGroup.getSelectedToggle();


        preguntaid.setText(listaResult.get(0));
        idOpcion1.setText(listaResult.get(1));
        idOpcion2.setText(listaResult.get(2));
        idOpcion3.setText(listaResult.get(3));
        idOpcion4.setText(listaResult.get(4));
    }

    public  void startController() throws ClassNotFoundException {

        ArrayList<String> listaResult = ContolBD.pintarPreguntas4(Transformar.selectRs4(numeroPregunta));

        /*preguntaid.setText(listaResult.get(0));
        idOpcion1.setText(listaResult.get(1));
        idOpcion2.setText(listaResult.get(2));
        idOpcion3.setText(listaResult.get(3));
        idOpcion4.setText(listaResult.get(4));*/

        preguntaid.setText(listaResult.get(0));
        idOpcion1.setText(listaResult.get(1));
        idOpcion2.setText(listaResult.get(2));
        idOpcion3.setText(listaResult.get(3));
        idOpcion4.setText(listaResult.get(4));

    }


}