package com.sw.model;

import java.io.Serializable;

/**
 *
 * @author HikingCarrot7
 */
public class Alumno extends Persona implements Serializable
{

    private String licenciatura;
    private double calificacion;

    public Alumno(String matricula, String nombre, int edad, String licenciatura, double calificacion)
    {
        super(matricula, nombre, edad);

        this.licenciatura = licenciatura;
        this.calificacion = calificacion;

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
