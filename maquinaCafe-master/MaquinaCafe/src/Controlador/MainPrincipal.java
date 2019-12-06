/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
    
import Modelo.Cambio;
import Vista.Index;

/**
 *
 * @author zeusj
 */
public class MainPrincipal {
    
    public static ControladorOrdenes controlador;
    
    public static void main(String[] args) {
        Cambio cambio = new Cambio(10, 10, 10, 10);
        controlador = new ControladorOrdenes(cambio);
        Index index = new Index();
        index.setVisible(true);
    }
}