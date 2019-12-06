/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Oscar Perera
 */
public class Capsula extends Ingrediente{

    public Capsula(int cantidadInicial) {
        super(cantidadInicial);
    }

    public void PrepararCafe(){
        super.setCantidadDisponible(super.getCantidadDisponible() - 1);
    }

    @Override
    public String toString() {
        return super.toString() + "\n"; 
    }      
}