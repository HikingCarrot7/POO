package com.sw.test;

import com.sw.dominio.CajaGrande;
import com.sw.dominio.CajaMediana;
import com.sw.dominio.CajaPequena;
import com.sw.dominio.Pedido;
import static java.lang.System.out;

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

        out.println(pedido.obtenerPrecioMinimoCajas());

        out.println(pedido.obtenerPrecioMinimoEspacio());

    }

}
