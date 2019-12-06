/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author zeusj
 */
public class ControladorReportes
{

    ArrayList<Orden> ListaOrdenes = new ArrayList<>();
    Cafe cafe;
    Azucar azucar;

    public ControladorReportes()
    {
        Capsula descafeinado = new Capsula(10);
        Capsula negro = new Capsula(10);
        Capsula capuccino = new Capsula(10);
        cafe = new Cafe(descafeinado, negro, capuccino);
        azucar = new Azucar(20);
    }

    public Cafe getCafe()
    {
        return cafe;
    }

    public void setCafe(Cafe cafe)
    {
        this.cafe = cafe;
    }

    public Azucar getAzucar()
    {
        return azucar;
    }

    public void setAzucar(Azucar azucar)
    {
        this.azucar = azucar;
    }

    public boolean AgregarOrden(Orden nuevaOrden)
    {
        int cucharadasAzucar = nuevaOrden.getCucharadasAzucar();
        if (getAzucar().getCantidadDisponible() >= cucharadasAzucar)
        {

            String tipoCafe = nuevaOrden.getTipoCafe();

            if (tipoCafe.equals("capuccino"))
                if (getCafe().getCapuccino().getCantidadDisponible() > 0)
                {
                    registrarOrden(nuevaOrden);
                    getCafe().getCapuccino().PrepararCafe();
                    getAzucar().agregarCucharadas(cucharadasAzucar);
                    return true;
                } else
                    return false;

            else if (tipoCafe.equals("negro"))
                if (getCafe().getNegro().getCantidadDisponible() > 0)
                {
                    registrarOrden(nuevaOrden);
                    getCafe().getNegro().PrepararCafe();
                    getAzucar().agregarCucharadas(cucharadasAzucar);
                    return true;
                } else
                    return false;

            else if (getCafe().getDescafeinado().getCantidadDisponible() > 0)
            {
                registrarOrden(nuevaOrden);
                getCafe().getDescafeinado().PrepararCafe();
                getAzucar().agregarCucharadas(cucharadasAzucar);
                return true;
            } else
                return false;

        } else
            return false;
    }

    public void registrarOrden(Orden nuevaOrden)
    {
        //System.out.println(nuevaOrden);
        ListaOrdenes.add(nuevaOrden);
    }

    public String ObtenerReporteOrdenes()
    {
        String reporteOrdenes = "";
        Iterator<Orden> ordenActual = ListaOrdenes.iterator();

        int indice = 1;
        while (ordenActual.hasNext())
        {

            Orden ordenIndice = ordenActual.next();
            reporteOrdenes = reporteOrdenes + "Orden " + indice + ordenIndice.toString() + "\n";
            indice++;

        }

        return reporteOrdenes;

    }

    public String ObtenerReporteIngredientes()
    {
        String reporteIngredientes;
        reporteIngredientes = cafe.toString() + azucar.toString();

        return reporteIngredientes;

    }
}
