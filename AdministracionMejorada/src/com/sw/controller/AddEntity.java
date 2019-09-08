package com.sw.controller;

import com.sw.model.Alumno;
import com.sw.model.Maestro;
import com.sw.view.AgregarAlumno;
import com.sw.view.AgregarMaestro;

/**
 *
 * @author Mohammed
 */
public class AddEntity
{

    private final DataTableUpdater dataTableUpdater;
    private boolean alumnoNuevo, maestroNuevo;

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

    public void anadirMaestro(AgregarMaestro agregarMaestro)
    {
        Maestro maestro = agregarMaestro.getMaestro();

        maestro.setMatricula(agregarMaestro.getNombre().getText());
        maestro.setNombre(agregarMaestro.getNombre().getText());
        maestro.setEdad(Integer.parseInt(agregarMaestro.getEdad().getText()));
        maestro.setSueldo(Double.parseDouble(agregarMaestro.getSueldoBase().getText()));
        maestro.setEspecialidad(agregarMaestro.getEspecialidad().getText());
        maestro.setUsario(agregarMaestro.getUsuario().getText());
        maestro.setPassword(agregarMaestro.getContrasena().getText());

        if (maestroNuevo)
            agregarMaestro.getMaestros().add(maestro);

        dataTableUpdater.updateTableMaestros(agregarMaestro.getAdministradoresGui().getTablaAdministradores(), agregarMaestro.getMaestros());

    }

    public void actualizarCamposRelleno(AgregarMaestro agregarMaestro)
    {
        Maestro maestro = agregarMaestro.getMaestro();
        maestroNuevo = true;

        if (maestro.getEdad() != 0)
        {
            agregarMaestro.getMatricula().setText(maestro.getMatricula());
            agregarMaestro.getNombre().setText(maestro.getNombre());
            agregarMaestro.getEdad().setText(maestro.getEdad() + "");
            agregarMaestro.getSueldoBase().setText(maestro.getSueldo() + "");
            agregarMaestro.getEspecialidad().setText(maestro.getEspecialidad());
            agregarMaestro.getUsuario().setText(maestro.getUsuario());
            agregarMaestro.getContrasena().setText(maestro.getPassword());

            maestroNuevo = false;

        }

    }

}
