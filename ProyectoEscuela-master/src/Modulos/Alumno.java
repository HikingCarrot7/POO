package Modulos;

import Clases.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Alumno extends Persona
{

    private java.sql.Date FechaInscripcion;
    private double CostoMensualidad;
    private double CostoInscripcion;
    private ArrayList PagosGenerales;
    private ArrayList PagosArticulos;
    private Grupo GrupoAlumno;
    private byte[] Fotografia;
    private int ID;

    //Constructor
    public Alumno(java.sql.Date FechaInscripcion, double CostoMensualidad, double CostoInscripcion, Grupo GrupoAlumno, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, Long NumCelular)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, Edad, NumCelular);
        this.FechaInscripcion = FechaInscripcion;
        this.CostoMensualidad = CostoMensualidad;
        this.CostoInscripcion = CostoInscripcion;
        this.GrupoAlumno = GrupoAlumno;

    }

    public Alumno(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, Long NumCelular, int ID, Date FechaInscripcion, byte[] Fotografia, double CostoMensualidad, double CostoInscripcion)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, Edad, NumCelular);
        this.ID = ID;
        this.FechaInscripcion = FechaInscripcion;
        this.Fotografia = Fotografia;
        this.CostoMensualidad = CostoMensualidad;
        this.CostoInscripcion = CostoInscripcion;
    }

    public Alumno(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int ID)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno);
        this.ID = ID;
    }

    //Metodos get
    public java.sql.Date getFechaInscripcion()
    {
        return FechaInscripcion;
    }

    public double getCostoMensualidad()
    {
        return CostoMensualidad;
    }

    public double getCostoInscripcion()
    {
        return CostoInscripcion;
    }

    public ArrayList getPagosGenerales()
    {
        return PagosGenerales;
    }

    public ArrayList getPagosArticulos()
    {
        return PagosArticulos;
    }

    public Grupo getGrupoAlumno()
    {
        return GrupoAlumno;

    }

    public byte[] getFotografia()
    {
        return Fotografia;
    }

    public int getID()
    {
        return ID;
    }

    //Metodos set
    public void setFechaInscripcion(java.sql.Date FechaInscripcion)
    {
        this.FechaInscripcion = FechaInscripcion;
    }

    public void setPagosGenerales(ArrayList PagosGenerales)
    {
        this.PagosGenerales = PagosGenerales;
    }

    public void setCostoMensualidad(double CostoMensualidad)
    {
        this.CostoMensualidad = CostoMensualidad;
    }

    public void setCostoInscripcion(double CostoInscripcion)
    {
        this.CostoInscripcion = CostoInscripcion;
    }

    public void setPagosGnerales(ArrayList PagosGnerales)
    {
        this.PagosGenerales = PagosGnerales;
    }

    public void setPagosArticulos(ArrayList PagosArticulos)
    {
        this.PagosArticulos = PagosArticulos;
    }

    public void setGrupoAlumno(Grupo GrupoAlumno)
    {
        this.GrupoAlumno = GrupoAlumno;
    }

    public void setFotografia(byte[] Fotografia)
    {
        this.Fotografia = Fotografia;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void MostrarAlumnos(JComboBox<Alumno> ComboAlumnosRA)
    {
        try
        {
            Conectar ConexionHorarios = new Conectar();
            ResultSet Res = ConexionHorarios.consulta("Select * FROM ingresoalumnos ");

            while (Res.next())
                ComboAlumnosRA.addItem(new Alumno(Res.getString("Nombre"), Res.getString("ApellidoPaterno"), Res.getString("ApellidoMaterno"), Res.getInt("IDAlumno")));

        } catch (Exception Ex)
        {
            System.err.println(Ex.getMessage());
        }

    }

    @Override
    public String toString()
    {
        return super.getNombre() + " " + super.getApellidoPaterno() + " " + super.getApellidoMaterno();
    }

}
