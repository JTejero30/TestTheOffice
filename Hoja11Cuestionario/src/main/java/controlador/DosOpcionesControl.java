package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import modelo.Transformar;

import java.util.ArrayList;

public class DosOpcionesControl {
    @FXML
    private ToggleGroup YN;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);
    @FXML
    private Button button;
    @FXML
    private VBox groupid;
    @FXML
    private Label preguntaid;
    @FXML
    private ToggleButton si;
    @FXML
    private ToggleButton no;
    //Aqui importante cambiarlo, que es donde empieza siempre la pregunta
    private int numeroPregunta = 6;
    @FXML
    void anteriorPregunta(ActionEvent event) throws ClassNotFoundException {
        numeroPregunta--;
        startController();
    }
    @FXML
    void siguientePregunta(ActionEvent event) throws ClassNotFoundException {

        //ContolBD.ejecutar(Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(numeroPregunta,si.isSelected()))));
        if(YN.getSelectedToggle()!=null){
            System.out.println(YN.getSelectedToggle().getUserData().toString());
            numeroPregunta++;
            startController();
        }
        else{
            alert.setContentText("Campos vacios, porfavor seleccione una opción para continuar");
            alert.show();
        }
        System.out.println("hola1" + ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(numeroPregunta, si.isSelected())));
        System.out.println("hola1" + Transformar.insertOption(ContolBD.hacerArrayPuntuaciones(Transformar.valuesOpcion(numeroPregunta, si.isSelected()))));
    }
    public void startController() {

        si.setUserData("si");
        no.setUserData("no");

        ArrayList<String> listaResult;

        try {
            listaResult = ContolBD.hacerArrayDeConsulta(Transformar.selectRs4(numeroPregunta));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        preguntaid.setText(listaResult.get(0));
        si.setText(listaResult.get(1));
        no.setText(listaResult.get(2));
    }
    //NO es necesario crear este método, directamente se hace el boolean en el otro metodo
    public boolean retornaOpcion() {

      /*  boolean opcion=false; //true= si false=no
        if (si.isSelected()) {
            opcion=true;
        }else {
            opcion=false;
        }*/
        return si.isSelected();
    }
}