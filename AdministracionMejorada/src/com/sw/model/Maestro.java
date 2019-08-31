package com.sw.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author HikingCarrot7
 */
public class Maestro extends Autoridad implements Serializable
{

    private String especialidad;
    private final ArrayList<Alumno> misAlumnos;

    public Maestro(String matricula, String nombre, int edad, double sueldo, String usuario, String password, String especialidad)
    {
        super(matricula, nombre, edad, sueldo, usuario, password);

        this.especialidad = especialidad;

        misAlumnos = new ArrayList<>();
    }

    public String getEspecialidad()
    {
        return especialidad;
    }

    public void setEspecialidad(String especialidad)
    {
        this.especialidad = especialidad;
    }

    @Override
    public void anadirEntidad(Persona persona)
    {
        misAlumnos.add((Alumno) persona);
    }

    @Override
    public void removerEntidad(Persona persona)
    {
        misAlumnos.remove((Alumno) persona);
    }

    @Override
    public ArrayList<? extends Persona> obtenerEntidades()
    {
        return misAlumnos;
    }

}
