package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Transformar;

import java.util.ArrayList;
import java.util.Random;


public class Controlador {

    @FXML
    private VBox VBox2resp;

    @FXML
    private VBox VBox4resp;

    @FXML
    private VBox VBoxImg;
    @FXML
    private ImageView imgA;

    @FXML
    private ImageView imgB;

    @FXML
    private ImageView imgC;

    @FXML
    private ImageView imgD;
    @FXML
    private ToggleButton btn1;

    @FXML
    private ToggleButton btn2;

    @FXML
    private ToggleButton btn3;

    @FXML
    private ToggleButton btn4;

    @FXML
    private ToggleGroup btnGroup;

    @FXML
    private VBox VboxContainer;

    @FXML
    private ToggleGroup YN;

    @FXML
    private Button buttonAnterior;

    @FXML
    private ToggleButton no;

    @FXML
    private Text preguntaid;

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
    private Button siguientePregunta;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private String personajeGanador;
    private ArrayList<Integer> listaPreguntasRandom;
    //Aqui importante cambiarlo, que es donde empieza siempre la pregunta
    private int numeroPreguntaArrayListRandom=0;

    public void randomInterval() {
        int min = 1; // valor minimo
        int max = 13; // valor maximo of the interval, hay que hacerlo automatico
        int size = 12; // tamaño de la lista
        //ArrayList<Integer> prueba = new ArrayList<>();
        ArrayList<Integer> listaPreguntasRandomL = new ArrayList<>();

       // prueba.add(6);
        //prueba.add(10);
        //prueba.add(13);
        //prueba.add(12);


        Random random = new Random();
        while (listaPreguntasRandomL.size() < size) {
            int number = random.nextInt(max - min + 1) + min;
            if (!listaPreguntasRandomL.contains(number)) {
                listaPreguntasRandomL.add(number);
            }
        }
        //listaPreguntasRandom = prueba;
        listaPreguntasRandom = listaPreguntasRandomL;
    }

    @FXML
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException {
        ContolBD.ejecutar(Transformar.eliminarUltimoInsert());
        numeroPreguntaArrayListRandom--;
        startController();
    }

    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException {


        if (numeroPreguntaArrayListRandom >= 11) {
            siguientePregunta.setText("Finalizar");

            System.out.println(calcularPersonaje());

            //limpiamos la tabla puntuaciones
            ContolBD.ejecutar("DELETE FROM personajes");

            //System.out.println("Eres" + personajeGanador);

        } else {
            comprobarClickado();
        }
    }

    @FXML
    void comprobarClickado() throws ClassNotFoundException {
        if (YN.getSelectedToggle() != null) {
            ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), YN.getSelectedToggle().getUserData().toString()))));

            numeroPreguntaArrayListRandom++;

            //Esto se hace para que al dar a la siguiente pregunta, no haya ninguna opcion seleccionada
            YN.getSelectedToggle().setSelected(false);

            startController();
        } else if (toogleGroup.getSelectedToggle() != null) {
            ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), toogleGroup.getSelectedToggle().getUserData().toString()))));
            numeroPreguntaArrayListRandom++;

            //Esto se hace para que al dar a la siguiente pregunta, no haya ninguna opcion seleccionada
            toogleGroup.getSelectedToggle().setSelected(false);

            startController();
        } else if (btnGroup.getSelectedToggle() != null) {
            ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(listaPreguntasRandom.get(numeroPreguntaArrayListRandom), btnGroup.getSelectedToggle().getUserData().toString()))));
            numeroPreguntaArrayListRandom++;

            //Esto se hace para que al dar a la siguiente pregunta, no haya ninguna opcion seleccionada
            btnGroup.getSelectedToggle().setSelected(false);

            startController();
        } else {
            alert.setContentText("Campos vacios, porfavor seleccione una opción para continuar");
            alert.show();
        }
    }

    void inicializarBotones() {
        try {
            si.setUserData("si");
            no.setUserData("no");

            resp1.setUserData("resp1");
            resp2.setUserData("resp2");
            resp3.setUserData("resp3");
            resp4.setUserData("resp4");

            btn1.setUserData("resp1");
            btn2.setUserData("resp2");
            btn3.setUserData("resp3");
            btn4.setUserData("resp4");

            Node removedNode2 = VBox2resp;
            Node removedNode4 = VBox4resp;
            Node removeNodeImg = VBoxImg;

            VboxContainer.getChildren().remove(removedNode2);
            VboxContainer.getChildren().remove(removedNode4);
            VboxContainer.getChildren().remove(removeNodeImg);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void startController() throws ClassNotFoundException {
        int tipoPregunta = ContolBD.verTipoPregunta(Transformar.tipoPregunta(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));
        ArrayList<String> listaResult;

        inicializarBotones();


        try {
            listaResult = ContolBD.hacerUnionDeConsulta(Transformar.selectRs4(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        switch (tipoPregunta) {
            case 1:
                VboxContainer.getChildren().add(VBox4resp);

                preguntaid.setText(listaResult.get(0));
                resp1.setText(listaResult.get(1));
                resp2.setText(listaResult.get(2));
                resp3.setText(listaResult.get(3));
                resp4.setText(listaResult.get(4));
                break;
            case 2:
                VboxContainer.getChildren().add(VBox2resp);

                preguntaid.setText(listaResult.get(0));
                si.setText(listaResult.get(1));
                no.setText(listaResult.get(2));
                break;
            case 3:
                VboxContainer.getChildren().add(VBoxImg);

                preguntaid.setText(listaResult.get(0));

                pintarImagenes();
                break;

            default:
                break;
        }
        buttonAnterior.setDisable(numeroPreguntaArrayListRandom <= 0);
        //si es la primera pregunta: anterior Disabled
    }

    void pintarImagenes() {

        ArrayList<String> listaResult;

        try {
            listaResult = ContolBD.hacerUnionDeConsulta(Transformar.selectRs4(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));

            String string1 = "C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/" + listaResult.get(1) + ".jpg";
            String string2 = "C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/" + listaResult.get(2) + ".jpg";
            String string3 = "C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/" + listaResult.get(3) + ".jpg";
            String string4 = "C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/" + listaResult.get(4) + ".jpg";

            Image image1 = new Image(string1);
            Image image2 = new Image(string2);
            Image image3 = new Image(string3);
            Image image4 = new Image(string4);

            imgA.setImage(image1);
            imgB.setImage(image2);
            imgC.setImage(image3);
            imgD.setImage(image4);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String calcularPersonaje() {

        int jugadorGanador = Integer.MIN_VALUE;
        int idGanador = 0;

        try {
            ArrayList<Integer> listaPersonajes = ContolBD.calcularPersonaje(Transformar.calcularPersonaje());
            for (int i = 0; i < listaPersonajes.size(); i++) {
                if (listaPersonajes.get(i) >= jugadorGanador) {
                    jugadorGanador = listaPersonajes.get(i);
                    idGanador = i;

                    System.out.println(idGanador);

                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        switch (idGanador) {
            case 0 -> personajeGanador = "michael";
            case 1 -> personajeGanador = "dwight";
            case 2 -> personajeGanador = "jim";
            case 3 -> personajeGanador = "pam";
            case 4 -> personajeGanador = "creed";
            case 5 -> personajeGanador = "kevin";
            case 6 -> personajeGanador = "andy";
            case 7 -> personajeGanador = "angela";
            case 8 -> personajeGanador = "stanley";
            case 9 -> personajeGanador = "meredith";
            case 10 -> personajeGanador = "oscar";
            default -> personajeGanador = "null";
        }
        return personajeGanador;
    }
}