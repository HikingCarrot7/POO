/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Mohammed
 */
public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            Pane ventana = (Pane) FXMLLoader.load(getClass().getResource("/vista/Vista.fxml"));

            Scene scene = new Scene(ventana);

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

}
