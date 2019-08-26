/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Asistencia
{

    private java.sql.Date FechaAsistencia;
    private String TipodeAsistencia;
    private int IDTipoAsistencia;

    //Constructores
    public Asistencia(int IDTipoAsistencia, String TipodeAsistencia)
    {
        this.IDTipoAsistencia = IDTipoAsistencia;
        this.TipodeAsistencia = TipodeAsistencia;
    }

    public Asistencia(Date FechaAsistencia, String TipodeAsistecia)
    {
        this.FechaAsistencia = FechaAsistencia;
        this.TipodeAsistencia = TipodeAsistecia;
    }

    public Asistencia()
    {
    }

    //Metodos get
    public Date getFechaAsistencia()
    {
        return FechaAsistencia;
    }

    public String getTipodeAsistecia()
    {
        return TipodeAsistencia;
    }

    public String getTipodeAsistencia()
    {
        return TipodeAsistencia;
    }

    public int getIDTipoAsistencia()
    {
        return IDTipoAsistencia;
    }

    //Metodos set
    public void setFechaAsistencia(Date FechaAsistencia)
    {
        this.FechaAsistencia = FechaAsistencia;
    }

    public void setTipodeAsistecia(String TipodeAsistecia)
    {
        this.TipodeAsistencia = TipodeAsistecia;
    }

    public void setTipodeAsistencia(String TipodeAsistencia)
    {
        this.TipodeAsistencia = TipodeAsistencia;
    }

    public void setIDTipoAsistencia(int IDTipoAsistencia)
    {
        this.IDTipoAsistencia = IDTipoAsistencia;
    }

    public void MostrarTipoAsistencia(JComboBox<Asistencia> ComboAsistenciaRA)
    {
        try
        {
            Conectar ConexionHorarios = new Conectar();
            ResultSet Res = ConexionHorarios.consulta("Select * FROM tipoasistencia ");
            while (Res.next())
            {
                ComboAsistenciaRA.addItem(new Asistencia(Res.getInt("IDTipoAsistencia"), Res.getString("TipoAsistencia")));
            }
        } catch (SQLException Ex)
        {
            System.err.println(Ex.getMessage());
        }

    }

    @Override
    public String toString()
    {
        return getTipodeAsistencia();
    }

}
