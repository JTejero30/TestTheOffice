package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Transformar;

import java.util.ArrayList;

public class ImagenesControl {

    @FXML
    private Button button;

    @FXML
    private VBox groupid;

    @FXML
    private ImageView img0;

    @FXML
    private ImageView img1;

    @FXML
    private ImageView img2;

    @FXML
    private ImageView img3;

    @FXML
    private Label preguntaid;

    @FXML
    private Text txt0;

    @FXML
    private Text txt1;

    @FXML
    private Text txt2;

    @FXML
    private Text txt3;

    @FXML
    void anteriorPregunta(ActionEvent event) {

    }

    @FXML
    void siguientePregunta(ActionEvent event) {

    }

    private int numeroPregunta = 5;

    //private Image casaLujo=  new Image("img/casaLujo.jpg");

    public void startController() throws ClassNotFoundException {

        ArrayList<String> listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));

        try {
            listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        preguntaid.setText(listaResult.get(0));
        /*
        img0.setImage(casaLujo);

         */

    }



}
