package com.sw.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HikingCarrot7
 */
public class Administrador extends Autoridad implements Serializable
{

    private final ArrayList<Maestro> misMaestros;

    public Administrador(String matricula, String nombre, int edad, double sueldo, String usuario, String password)
    {
        super(matricula, nombre, edad, sueldo, usuario, password);

        misMaestros = new ArrayList<>();

    }

    @Override
    public double getSueldo()
    {
        return super.getSueldo() * 1.15;
    }

    @Override
    public void anadirEntidad(Persona persona)
    {
        misMaestros.add((Maestro) persona);
    }

    @Override
    public void removerEntidad(Persona persona)
    {
        misMaestros.remove((Maestro) persona);
    }

    @Override
    public ArrayList<? extends Persona> obtenerEntidades()
    {
        return misMaestros;
    }

}
