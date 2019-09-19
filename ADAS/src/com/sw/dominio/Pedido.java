package com.sw.dominio;

/**
 *
 * @author HikingCarrot7
 */
public class Pedido
{

    private int cantidadBolsas;

    public Pedido(int cantidadBolsas)
    {
        this.cantidadBolsas = cantidadBolsas;
    }

    public int getCantidadBolsas()
    {
        return cantidadBolsas;
    }

    public void setCantidadBolsas(int cantidadBolsas)
    {
        this.cantidadBolsas = cantidadBolsas;
    }

    public double getPrecioBolsas()
    {
        return this.cantidadBolsas * Bolsa.getPRECIO();
    }

    public int obtenerCajasMinimasGrandes()
    {
        return 0;
    }

    public int obtenerCajasMinimasMedianas()
    {
        return 0;
    }

    public int obtenerCajasMinimasPequenas()
    {
        return 0;
    }

    public double obtenerPrecioMinimoCajas()
    {
        return 0;
    }

    public double obtenerPrecioMinimoEspacio()
    {
        return 0;
    }

}
