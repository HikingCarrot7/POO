package com.sw.model;

import com.sw.interfaces.InicioSesion;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mohammed
 */
public abstract class Autoridad extends Persona implements InicioSesion, Serializable
{

    private static final long serialVersionUID = -2987264484371790143L;

    private String usuario, password;
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

    public void setUsario(String usuario)
    {
        this.usuario = usuario;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public abstract void anadirEntidad(Persona persona);

    public abstract void removerEntidad(Persona persona);

    public abstract ArrayList<? extends Persona> obtenerEntidades();

}
