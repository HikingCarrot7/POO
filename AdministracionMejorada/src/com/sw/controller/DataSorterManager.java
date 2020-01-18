package com.sw.controller;

import com.sw.model.Alumno;
import com.sw.model.Maestro;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author Mohammed
 */
public class DataSorterManager
{

    public void ordenarAlumnos(ArrayList<Maestro> maestros, int indexCurrentMaestro, String ordenarPor)
    {

        Comparator<Alumno> orden = null;

        switch (ordenarPor)
        {
            case "Licenciatura":
                orden = Comparator.comparing(Alumno::getLicenciatura);
                break;

            case "Nombre":
                orden = Comparator.comparing(Alumno::getNombre);
                break;

            case "Calificación":
                orden = Comparator.comparing(Alumno::getCalificacion).reversed();
                break;

        }

        ArrayList<Alumno> alumnos = (ArrayList<Alumno>) maestros.get(indexCurrentMaestro).obtenerEntidades();
        alumnos = (ArrayList<Alumno>) alumnos.stream().sorted(orden).collect(Collectors.toList());
        maestros.get(indexCurrentMaestro).setEntidades(alumnos);

    }

    public void ordenarMaestros(ArrayList<Maestro> maestros, String ordenarPor)
    {
        Comparator<Maestro> orden = null;

        switch (ordenarPor)
        {
            case "Especialidad":
                orden = Comparator.comparing(Maestro::getEspecialidad);
                break;

            case "Nombre":
                orden = Comparator.comparing(Maestro::getNombre);
                break;

            case "Sueldo":
                orden = Comparator.comparing(Maestro::getSueldo).reversed();
                break;

        }

        ArrayList<Maestro> maestrosOrdenados = (ArrayList<Maestro>) maestros.stream()
                .sorted(orden)
                .collect(Collectors.toList());

        maestros.clear();
        maestros.addAll(maestrosOrdenados);

    }

}
