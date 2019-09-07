package com.sw.controller;

import com.sw.model.Alumno;
import com.sw.view.AgregarAlumno;

/**
 *
 * @author Mohammed
 */
public class AddEntity
{

    private final DataTableUpdater dataTableUpdater;
    private boolean alumnoNuevo;

    public AddEntity(DataTableUpdater dataTableUpdater)
    {
        this.dataTableUpdater = dataTableUpdater;
    }

    public void anadirAlumno(AgregarAlumno agregarAlumno)
    {
        Alumno alumno = agregarAlumno.getAlumno();

        alumno.setMatricula(agregarAlumno.getMatricula().getText());
        alumno.setNombre(agregarAlumno.getNombre().getText());
        alumno.setEdad(Integer.parseInt(agregarAlumno.getEdad().getText()));
        alumno.setLicenciatura(agregarAlumno.getLicenciatura().getText());
        alumno.setCalificacion(Double.parseDouble(agregarAlumno.getCalificacion().getText()));

        if (alumnoNuevo)
            agregarAlumno.getMaestros().get(agregarAlumno.getIndexCurrentMaestro()).anadirEntidad(alumno);

        dataTableUpdater.updateTableAlumnos(agregarAlumno.getMaestrosGui().getTablaMaestros(), agregarAlumno.getMaestros(), agregarAlumno.getIndexCurrentMaestro());
    }

    public void actualizarCamposRelleno(AgregarAlumno agregarAlumno)
    {
        Alumno alumno = agregarAlumno.getAlumno();
        alumnoNuevo = true;

        if (alumno.getEdad() != 0)
        {
            agregarAlumno.getMatricula().setText(alumno.getMatricula());
            agregarAlumno.getNombre().setText(alumno.getNombre());
            agregarAlumno.getEdad().setText(alumno.getEdad() + "");
            agregarAlumno.getLicenciatura().setText(alumno.getLicenciatura());
            agregarAlumno.getCalificacion().setText(alumno.getCalificacion() + "");

            alumnoNuevo = false;

        }

    }

}
