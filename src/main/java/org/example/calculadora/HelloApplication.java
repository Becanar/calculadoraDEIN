package org.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Clase principal de la aplicación de la calculadora.
 * Extiende de {@link javafx.application.Application} y es el punto de entrada
 * de la aplicación JavaFX.
 */
public class HelloApplication extends Application {
    /**
     * Método que se ejecuta cuando la aplicación se inicia.
     * Carga el archivo FXML y configura la ventana principal de la aplicación.
     *
     * @param stage La ventana principal (Stage) de la aplicación.
     * @throws IOException Si hay un problema al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    /**
     * Método principal que lanza la aplicación.
     *
     * @param args Los argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}