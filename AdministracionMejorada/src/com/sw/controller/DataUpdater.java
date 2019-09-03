package com.sw.controller;

import com.sw.model.Alumno;
import com.sw.model.Maestro;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mohammed
 */
public class DataUpdater
{

    public void updateTableMaestros(JTable table, ArrayList<? extends Maestro> maestros)
    {

        DefaultTableModel dm = (DefaultTableModel) table.getModel();

        if (dm.getRowCount() > 0)
            dm.removeRow(0);

        for (int i = 0; i < maestros.size(); i++)
        {
            table.setValueAt(maestros.get(i).getEspecialidad(), i, 0);
            table.setValueAt(maestros.get(i).getMatricula(), i, 1);
            table.setValueAt(maestros.get(i).getNombre(), i, 2);
            table.setValueAt(String.format("$%,.2f", maestros.get(i).getSueldo()), i, 3);
            table.setValueAt(maestros.get(i).getUsuario(), i, 4);
            table.setValueAt(maestros.get(i).getPassword(), i, 5);
        }

    }

    public void updateTableAlumnos(JTable table, ArrayList<? extends Maestro> maestros, int indexCurrentMaestro)
    {
        DefaultTableModel dm = (DefaultTableModel) table.getModel();

        if (dm.getRowCount() > 0)
            dm.removeRow(0);

        for (int i = 0; i < maestros.get(indexCurrentMaestro).obtenerEntidades().size(); i++)
        {
            Alumno alumno = (Alumno) maestros.get(indexCurrentMaestro).obtenerEntidades().get(i);

            table.setValueAt(alumno.getLicenciatura(), i, 0);
            table.setValueAt(alumno.getMatricula(), i, 1);
            table.setValueAt(alumno.getNombre(), i, 2);
            table.setValueAt(String.format("%,.2f", alumno.getCalificacion()), i, 3);

        }

    }

}
