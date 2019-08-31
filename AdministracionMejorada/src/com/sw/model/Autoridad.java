package com.sw.model;

import com.sw.interfaces.InicioSesion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HikingCarrot7
 */
public abstract class Autoridad extends Persona implements InicioSesion, Serializable
{

    private final String usuario, password;
    private double sueldo;

    public Autoridad(String matricula, String nombre, int edad, double sueldo, String usuario, String password)
    {
        super(matricula, nombre, edad);

        this.sueldo = sueldo;
        this.usuario = usuario;
        this.password = password;
    }

    public double getSueldo()
    {
        return sueldo;
    }

    public void setSueldo(double sueldo)
    {
        this.sueldo = sueldo;
    }

    @Override
    public String getUsuario()
    {
        return usuario;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    public abstract void anadirEntidad(Persona persona);

    public abstract void removerEntidad(Persona persona);

    public abstract ArrayList<? extends Persona> obtenerEntidades();

}
