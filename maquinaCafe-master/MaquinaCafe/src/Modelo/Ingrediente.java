/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author zeusj
 */
public class Ingrediente {
    private final int cantidadInicial;
    private int cantidadDisponible;

    public Ingrediente(int cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
        this.cantidadDisponible = cantidadInicial;
    }

    public int getCantidadInicial() {
        return cantidadInicial;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    @Override
    public String toString() {
        return  "Cantidad Inicial: " + cantidadInicial + "\nCantidad Disponible: " 
                + cantidadDisponible  + "\n";
    }
    
    
}