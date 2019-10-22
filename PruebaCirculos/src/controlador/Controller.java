/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Mohammed
 */
public class Controller implements Initializable
{

    @FXML
    private Canvas canvas;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        Platform.runLater(() ->
        {
            new Draw(getCanvas()).draw();
        });

    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    @FXML
    private void mouseClicked(MouseEvent event)
    {
        System.out.println("Hola");
    }

}
