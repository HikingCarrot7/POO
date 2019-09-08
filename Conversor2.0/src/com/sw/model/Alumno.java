package com.sw.model;

import java.io.Serializable;

/**
 *
 * @author Mohammed
 */
public class Alumno extends Persona implements Serializable
{

    private static final long serialVersionUID = 1726646740249056652L;

    private String licenciatura;
    private double calificacion;

    public Alumno(String matricula, String nombre, int edad, String licenciatura, double calificacion)
    {
        super(matricula, nombre, edad);

        this.licenciatura = licenciatura;
        this.calificacion = calificacion;

    }

    public Alumno()
    {
        this(null, null, 0, null, 0);
    }

    public String getLicenciatura()
    {
        return licenciatura;
    }

    public void setLicenciatura(String licenciatura)
    {
        this.licenciatura = licenciatura;
    }

    public double getCalificacion()
    {
        return calificacion;
    }

    public void setCalificacion(double calificacion)
    {
        this.calificacion = calificacion;
    }

}
