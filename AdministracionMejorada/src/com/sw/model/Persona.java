package com.sw.model;

import java.io.Serializable;

/**
 *
 * @author Mohammed
 */
public abstract class Persona implements Serializable
{

    private static final long serialVersionUID = 962586902261291984L;

    private String matricula, nombre;
    private int edad;

    public Persona(String matricula, String nombre, int edad)
    {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getMatricula()
    {
        return matricula;
    }

    public void setMatricula(String matricula)
    {
        this.matricula = matricula;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

}
