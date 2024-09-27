package org.example.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * Controlador de la calculadora que maneja las operaciones básicas: sumar, restar,
 * multiplicar y dividir. También gestiona la validación del texto ingresado en los
 * campos de entrada.
 */
public class CalculadoraController {

    @FXML
    private Label LabelError;

    @FXML
    private Label LabelOP1;

    @FXML
    private Label LabelOP2;

    @FXML
    private Label LabelResultado;

    @FXML
    private Button btCalcular;

    @FXML
    private RadioButton btDividir;

    @FXML
    private RadioButton btMultiplicar;

    @FXML
    private RadioButton btRestar;

    @FXML
    private RadioButton btSumar;

    @FXML
    private ToggleGroup grpOP;

    @FXML
    private Label lblCalculadora;

    @FXML
    private TextField txtOP1;

    @FXML
    private TextField txtOP2;

    @FXML
    private TextField txtResultado;
    /**
     * Método que maneja el evento  cuando se presiona el botón "Calcular".
     * Verifica que los textos ingresados en los campos de entrada sean válidos (números)
     * y realiza la operación seleccionada (suma, resta, multiplicación o división).
     *
     * @param event El evento de la acción del botón.
     */
   @FXML
    void calcular(ActionEvent event) {
        if(textoValido(txtOP1) && textoValido(txtOP2)){
            if(btSumar.isSelected()){
                sumar(txtOP1,txtOP2);
            }if(btRestar.isSelected()){
                restar(txtOP1,txtOP2);
            }
            if(btMultiplicar.isSelected()){
                multiplicar(txtOP1,txtOP2);
            }
            if(btDividir.isSelected()){
                if(Double.parseDouble(txtOP2.getText())==0){
                    LabelError.setText("ERROR! No se puede dividir entre 0!");
                    LabelError.setStyle("-fx-text-fill: red;");
                }else{
                dividir(txtOP1,txtOP2);}
            }
            else {
                LabelError.setText("ERROR! Selecciona una operación!");
                LabelError.setStyle("-fx-text-fill: red;");
            }
        }
    }
    /**
     * Realiza la división entre los dos números ingresados en los campos de texto.
     * Si la operación es válida, el resultado se muestra en el campo de resultado.
     *
     * @param txtOP1 El primer operando (TextField).
     * @param txtOP2 El segundo operando (TextField).
     */
    private void dividir(TextField txtOP1, TextField txtOP2) {
        double num1=Double.parseDouble(txtOP1.getText());
        double num2=Double.parseDouble(txtOP2.getText());
        double res=num1/num2;
        txtResultado.setText(""+res);
    }
    /**
     * Realiza la multiplicación entre los dos números ingresados en los campos de texto.
     * Si la operación es válida, el resultado se muestra en el campo de resultado.
     *
     * @param txtOP1 El primer operando (TextField).
     * @param txtOP2 El segundo operando (TextField).
     */
    private void multiplicar(TextField txtOP1, TextField txtOP2) {
        double num1=Double.parseDouble(txtOP1.getText());
        double num2=Double.parseDouble(txtOP2.getText());
        double res=num1*num2;
        txtResultado.setText(""+res);
    }

    /**
     * Realiza la resta entre los dos números ingresados en los campos de texto.
     * Si la operación es válida, el resultado se muestra en el campo de resultado.
     *
     * @param txtOP1 El primer operando (TextField).
     * @param txtOP2 El segundo operando (TextField).
     */
    private void restar(TextField txtOP1, TextField txtOP2) {
        double num1=Double.parseDouble(txtOP1.getText());
        double num2=Double.parseDouble(txtOP2.getText());
        double res=num1-num2;
        txtResultado.setText(""+res);
    }
    /**
     * Realiza la suma entre los dos números ingresados en los campos de texto.
     * Si la operación es válida, el resultado se muestra en el campo de resultado.
     *
     * @param txtOP1 El primer operando (TextField).
     * @param txtOP2 El segundo operando (TextField).
     */
    private void sumar(TextField txtOP1, TextField txtOP2) {
        double num1=Double.parseDouble(txtOP1.getText());
        double num2=Double.parseDouble(txtOP2.getText());
        double res=num1+num2;
        txtResultado.setText(""+res);
    }
    /**
     * Verifica si el texto ingresado en un campo de texto es un número válido.
     * Si no es válido, muestra un mensaje de error.
     *
     * @param txt El campo de texto a validar.
     * @return true si el texto es un número válido, false en caso contrario.
     */
    private boolean textoValido(TextField txt) {
        try {
        // Intenta convertir el texto a un número
            double num = Double.parseDouble(txt.getText());
            return true;  // El texto es un número válido
        } catch (NumberFormatException e) {
        // Si ocurre una excepción,
            LabelError.setText("ERROR! El texto no es un número válido!");
            LabelError.setStyle("-fx-text-fill: red;");
            return false;
        }
    }


}
