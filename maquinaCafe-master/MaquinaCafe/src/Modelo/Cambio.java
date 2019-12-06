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
public class Cambio {
    
    final int MonedasPesoIniciales; 
    final int Monedas2PesosIniciales;
    final int Monedas5PesosIniciales;
    final int Monedas10PesosIniciales;   
    int MonedasPeso;
    int Monedas2Pesos;
    int Monedas5Pesos;
    int Monedas10Pesos;
      
    public Cambio(int MonedasPeso, int Monedas2Pesos, int Monedas5Pesos, int Monedas10Pesos) {      
        this.MonedasPeso = MonedasPeso ;
        this.Monedas2Pesos =  Monedas2Pesos;
        this.Monedas5Pesos =  Monedas5Pesos ;
        this.Monedas10Pesos =   Monedas10Pesos;        
        MonedasPesoIniciales = MonedasPeso; 
        Monedas2PesosIniciales = Monedas2Pesos;
        Monedas5PesosIniciales = Monedas5Pesos;
        Monedas10PesosIniciales = Monedas10Pesos;   
    }

    public int getMonedasPeso() {
        return MonedasPeso;
    }
    
    public int getMonedas2Pesos() {
        return Monedas2Pesos;
    }

    public int getMonedas5Pesos() {
        return Monedas5Pesos;
    }

    public int getMonedas10Pesos() {
        return Monedas10Pesos;
    }

    public void setMonedasPeso(int MonedasPeso) {
        this.MonedasPeso = MonedasPeso;
    }

    public void setMonedas2Pesos(int Monedas2Pesos) {
        this.Monedas2Pesos = Monedas2Pesos;
    }

    public void setMonedas5Pesos(int Monedas5Pesos) {
        this.Monedas5Pesos = Monedas5Pesos;
    }

    public void setMonedas10Pesos(int Monedas10Pesos) {
        this.Monedas10Pesos = Monedas10Pesos;
    }
   
    @Override
    public String toString() {
        String respuesta = "";
        if(MonedasPeso > 0){
            respuesta = respuesta + "Monedas de 1 Peso: " + MonedasPeso + "\n";
        }
        if(Monedas2Pesos > 0){
            respuesta = respuesta + "Monedas de 2 Pesos: " + Monedas2Pesos + "\n";
        }
        if(Monedas5Pesos > 0){
            respuesta = respuesta + "Monedas de 5 Pesos: " + Monedas5Pesos + "\n";
        }
        if(Monedas10Pesos > 0){
            respuesta = respuesta + "Monedas de 10 Pesos: " + Monedas10Pesos + "\n";
        }
        return respuesta;
    }
    
    public String cambioInicialToString() {
        String respuesta = "";
        if(MonedasPesoIniciales > 0){
            respuesta = respuesta + "Monedas de 1 Peso: " + MonedasPesoIniciales + "\n";
        }
        if(Monedas2PesosIniciales > 0){
            respuesta = respuesta + "Monedas de 2 Pesos: " + Monedas2PesosIniciales + "\n";
        }
        if(Monedas5PesosIniciales > 0){
            respuesta = respuesta + "Monedas de 5 Pesos: " + Monedas5PesosIniciales + "\n";
        }
        if(Monedas10PesosIniciales > 0){
            respuesta = respuesta + "Monedas de 10 Pesos: " + Monedas10PesosIniciales + "\n";
        }
        return respuesta;
    }
}