package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.Transformar;

import java.util.ArrayList;
import java.util.Random;

public class DosOpcionesControl {

    private ArrayList<Integer> listaPreguntasRandom;
    @FXML
    private VBox VBox2resp;
    @FXML
    private VBox VBox4resp;
    @FXML
    private VBox VboxContainer;
    @FXML
    private ToggleGroup YN;
    @FXML
    private AnchorPane answerAnchorPane;
    @FXML
    private BorderPane bordP;
    @FXML
    private Button button;
    @FXML
    private VBox groupid;
    @FXML
    private ToggleButton no;
    @FXML
    private Label preguntaid;
    @FXML
    private ToggleButton resp1;
    @FXML
    private ToggleButton resp2;
    @FXML
    private ToggleButton resp3;
    @FXML
    private ToggleButton resp4;
    @FXML
    private ToggleButton si;
    @FXML
    private ToggleGroup toogleGroup;
    @FXML
    private ToggleGroup toogleGroup1;
    @FXML
    private VBox VBox4;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    //Aqui importante cambiarlo, que es donde empieza siempre la pregunta
    private int numeroPreguntaArrayListRandom = 0;

    @FXML
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException {
        numeroPreguntaArrayListRandom--;
        startController();
    }

    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException {



        if (numeroPreguntaArrayListRandom >= 4) {
            System.out.println(calcularPersonaje());
            System.out.println("fin");




        } else {
            if (YN.getSelectedToggle() != null) {
                // System.out.println(YN.getSelectedToggle().getUserData().toString());

                //System.out.println(toogleGroup.getSelectedToggle().getUserData());
                // System.out.println(Transformar.valuesOpcion(numeroPregunta,toogleGroup.getSelectedToggle().getUserData().toString()));

                ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), YN.getSelectedToggle().getUserData().toString()))));

                // System.out.println(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), YN.getSelectedToggle().getUserData().toString()))));

                System.out.println("YN");
                System.out.println(numeroPreguntaArrayListRandom);

                numeroPreguntaArrayListRandom++;

                //Esto se hace para que al dar a la siguiente pregunta, no haya ninguna opcion seleccionada
                YN.getSelectedToggle().setSelected(false);

                startController();
            } else if (toogleGroup.getSelectedToggle() != null) {
                ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), toogleGroup.getSelectedToggle().getUserData().toString()))));
                System.out.println("toogle");
                System.out.println(numeroPreguntaArrayListRandom);
                numeroPreguntaArrayListRandom++;

                //Esto se hace para que al dar a la siguiente pregunta, no haya ninguna opcion seleccionada
                toogleGroup.getSelectedToggle().setSelected(false);

                startController();
            } else {
                alert.setContentText("Campos vacios, porfavor seleccione una opción para continuar");
                alert.show();
            }
        }
    }

    public void startController() throws ClassNotFoundException {
        int tipoPregunta = ContolBD.verTipoPregunta(Transformar.tipoPregunta(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));

        si.setUserData("si");
        no.setUserData("no");

        resp1.setUserData("resp1");
        resp2.setUserData("resp2");
        resp3.setUserData("resp3");
        resp4.setUserData("resp4");

        Node removedNode2 = VBox2resp;
        Node removedNode4 = VBox4resp;

        ArrayList<String> listaResult;

        try {
            listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));
            System.out.println("hola1 " + listaResult);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (tipoPregunta == 1) {
            VboxContainer.getChildren().remove(removedNode2);
            VboxContainer.getChildren().remove(removedNode4);

            VboxContainer.getChildren().add(VBox4resp);

            preguntaid.setText(listaResult.get(0));
            resp1.setText(listaResult.get(1));
            resp2.setText(listaResult.get(2));
            resp3.setText(listaResult.get(3));
            resp4.setText(listaResult.get(4));

        } else if (tipoPregunta == 2) {
            VboxContainer.getChildren().remove(removedNode4);
            VboxContainer.getChildren().remove(removedNode2);

            VboxContainer.getChildren().add(VBox2resp);

            preguntaid.setText(listaResult.get(0));
            si.setText(listaResult.get(1));
            no.setText(listaResult.get(2));

        } else {
            System.out.println("Error");
        }
    }

    public void randomInterval() {
        int min = 1; // valor minimo
        int max = 8; // valor maximo of the interval
        int size = 5; // tamaño de la lista

        ArrayList<Integer> listaPreguntasRandomL = new ArrayList<>();

        Random random = new Random();
        while (listaPreguntasRandomL.size() < size) {
            int number = random.nextInt(max - min + 1) + min;
            if (!listaPreguntasRandomL.contains(number)) {
                listaPreguntasRandomL.add(number);
            }
        }
        System.out.println(listaPreguntasRandomL);
        listaPreguntasRandom = listaPreguntasRandomL;
    }

    public int calcularPersonaje(){

        int jugadorGanador=Integer.MIN_VALUE;
        int idGanador=0;
        try {
            ArrayList<Integer> listaPersonajes=ContolBD.calcularPersonaje(Transformar.calcularPersonaje());
            for (int i =0;i<listaPersonajes.size();i++){
                if (listaPersonajes.get(i)>=jugadorGanador){
                    jugadorGanador=listaPersonajes.get(i);
                    idGanador=i;
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return idGanador;
    }
}