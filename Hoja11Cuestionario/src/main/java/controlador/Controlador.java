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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Transformar;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;


import javafx.scene.control.Label;
import javafx.scene.control.Slider;


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
    private String personajeGanador;
    private ArrayList<Integer> listaPreguntasRandom;
    @FXML
    private ToggleGroup toogleGroup1;


    @FXML
    private Button siguientePregunta;

    private Alert alert = new Alert(Alert.AlertType.INFORMATION);


    //Aqui importante cambiarlo, que es donde empieza siempre la pregunta
    private int numeroPreguntaArrayListRandom = 0;

    @FXML
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException {
        ContolBD.ejecutar(Transformar.eliminarUltimoInsert());
        numeroPreguntaArrayListRandom--;
        startController();
    }

    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException {


        if (numeroPreguntaArrayListRandom >= 4) {
            siguientePregunta.setText("Finalizar");

            System.out.println(calcularPersonaje());
            System.out.println("fin");

            System.out.println("Eres"+personajeGanador);



        } else {
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
            } else {
                alert.setContentText("Campos vacios, porfavor seleccione una opción para continuar");
                alert.show();
            }
        }
    }

    public void startController() throws ClassNotFoundException {
        int tipoPregunta = ContolBD.verTipoPregunta(Transformar.tipoPregunta(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));

        System.out.println(tipoPregunta);

        no.setUserData("no");

        resp1.setUserData("resp1");
        resp2.setUserData("resp2");
        resp3.setUserData("resp3");
        resp4.setUserData("resp4");

        Node removedNode2 = VBox2resp;
        Node removedNode4 = VBox4resp;
        Node removeNodeImg= VBoxImg;

        VboxContainer.getChildren().remove(removedNode2);
        VboxContainer.getChildren().remove(removedNode4);
        VboxContainer.getChildren().remove(removeNodeImg);

        ArrayList<String> listaResult;


        try {
            listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(listaPreguntasRandom.get(numeroPreguntaArrayListRandom)));
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

                /* estando en una pregunta de tipo imagen necesito
                *
                *       1.el nombre de la imagen, alojado en la base de datos
                *       2.concatenarlo al siguiente constructor:
                *           File imageFile = new File("../../../../img/"+nombre+".jpg"); // Ruta del archivo local
                *       3.repetirlo para cada imagen/respuesta
                *       4. rezar*/

               // for (int i = 0; i <4 ; i++) {}






                String string1="C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/"+listaResult.get(1)+".jpg";
                String string2="C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/"+listaResult.get(2)+".jpg";
                String string3="C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/"+listaResult.get(3)+".jpg";
                String string4="C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/"+listaResult.get(4)+".jpg";

                Image image1= new Image(string1);
                Image image2= new Image(string2);
                Image image3= new Image(string3);
                Image image4= new Image(string4);

                imgA.setImage(image1);
                imgB.setImage(image2);
                imgC.setImage(image3);
                imgD.setImage(image4);


               /*String string1="C:/Users/javit/IdeaProjects/TheOffice/TestTheOffice/Hoja11Cuestionario/img/vaca.jpg";
                Image image1= new Image(string1);
                imgA.setImage(image1);
                imgB.setImage(image1);
                imgC.setImage(image1);
                imgD.setImage(image1);*/

                si.setSelected(true);

                break;

            default:
                break;
        }
        buttonAnterior.setDisable(numeroPreguntaArrayListRandom <= 0);
        //si es la primera pregunta: anterior Disabled
    }

    public void randomInterval() {
        int min = 1; // valor minimo
        int max = 13; // valor maximo of the interval, hay que hacerlo automatico
        int size = 9; // tamaño de la lista
        ArrayList<Integer> prueba = new ArrayList<>();
        ArrayList<Integer> listaPreguntasRandomL = new ArrayList<>();

        prueba.add(13);
        prueba.add(12);

        Random random = new Random();
        while (listaPreguntasRandomL.size() < size) {
            int number = random.nextInt(max - min + 1) + min;
            if (!listaPreguntasRandomL.contains(number)) {
                listaPreguntasRandomL.add(number);
            }
        }
        listaPreguntasRandom = prueba;
        //listaPreguntasRandom = listaPreguntasRandomL;
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
            case 1 -> personajeGanador = "Dwight";
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