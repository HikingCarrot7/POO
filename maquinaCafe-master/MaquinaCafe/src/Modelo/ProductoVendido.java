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
public class ProductoVendido {
    
    Capsula cafeVendido ;
    int gramosAzucar;

    public ProductoVendido(Capsula cafeVendido, int gramosAzucar) {
        this.cafeVendido = cafeVendido;
        this.gramosAzucar = gramosAzucar;
    }

    public Capsula getCafeVendido() {
        return cafeVendido;
    }

    public void setCafeVendido(Capsula cafeVendido) {
        this.cafeVendido = cafeVendido;
    }

    public int getGramosAzucar() {
        return gramosAzucar;
    }

    public void setGramosAzucar(int gramosAzucar) {
        this.gramosAzucar = gramosAzucar;
    }
    
}
