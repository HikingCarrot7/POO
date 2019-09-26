package com.sw.test;

import com.sw.dominio.CajaGrande;
import com.sw.dominio.CajaMediana;
import com.sw.dominio.CajaPequena;
import com.sw.dominio.Pedido;

/**
 *
 * @author HikingCarrot7
 */
public class MyJavaCoffeeOutlet
{

    public static void main(String[] args)
    {
        CajaGrande cajaGrande = new CajaGrande(20, 10);
        CajaMediana cajaMediana = new CajaMediana(10, 5);
        CajaPequena cajaPequena = new CajaPequena(5, 3);

        Pedido pedido = new Pedido(56);

        System.out.println(pedido.obtenerPrecioMinimoCajas());

        System.out.println(pedido.obtenerPrecioMinimoEspacio());

    }

}
