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
public class Cafe{

    private Capsula descafeinado;
    private Capsula negro;
    private Capsula capuccino;

    public Cafe(Capsula descafeinado, Capsula negro, Capsula capuccino) {
        this.descafeinado = descafeinado;
        this.negro = negro;
        this.capuccino = capuccino;
    }

    public Capsula getDescafeinado() {
        return descafeinado;
    }

    public void setDescafeinado(Capsula descafeinado) {
        this.descafeinado = descafeinado;
    }

    public Capsula getNegro() {
        return negro;
    }

    public void setNegro(Capsula negro) {
        this.negro = negro;
    }

    public Capsula getCapuccino() {
        return capuccino;
    }

    public void setCapuccino(Capsula capuccino) {
        this.capuccino = capuccino;
    }

    @Override
    public String toString() {      
        return "Café Descafeinado :\n" + descafeinado.toString()+ "Café Negro: \n" + 
                negro.toString() + "Café Capuccino: \n" + capuccino.toString();
             
    } 
}