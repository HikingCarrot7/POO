package com.sw.dominio;

/**
 *
 * @author HikingCarrot7
 */
public class CajaPequena
{

    private int capacidad;
    private double precio;

    public CajaPequena(int capacidad, double precio)
    {
        this.capacidad = capacidad;
        this.precio = precio;
    }

    public int getCapacidad()
    {
        return capacidad;
    }

    public void setCapacidad(int capacidad)
    {
        this.capacidad = capacidad;
    }

    public double getPrecio()
    {
        return precio;
    }

    public void setPrecio(double precio)
    {
        this.precio = precio;
    }

}
