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
public class Azucar extends Ingrediente{
    
    public Azucar(int cantidadInicial) {
        super(cantidadInicial);
    }
    
    public void agregarCucharadas(int cantidadDeCucharadas){
        super.setCantidadDisponible(super.getCantidadDisponible() - cantidadDeCucharadas);
    }

    @Override
    public String toString() {
        return "Azucar: \n " + super.toString(); //To change body of generated methods, choose Tools | Templates.
    } 
}