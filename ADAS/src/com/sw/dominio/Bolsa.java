package com.sw.dominio;

/**
 *
 * @author HikingCarrot7
 */
public class Bolsa
{

    private final static double PRECIO = 250;
    private int tamanio;

    public Bolsa(int tamanio, double precio)
    {
        this.tamanio = tamanio;

    }

    public int getTamanio()
    {
        return tamanio;
    }

    public void setTamanio(int tamanio)
    {
        this.tamanio = tamanio;
    }

    public static double getPRECIO()
    {
        return PRECIO;
    }

}
