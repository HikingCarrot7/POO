package Modulos;

import Clases.Conectar;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Maestro extends Persona
{

    private Date FechaInicio;
    private int AñosExp;
    private byte[] Fotografia;
    private int IDMaestro;

    public Maestro(Date FechaInicio, int AñosExp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, Long NumCelular)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, Edad, NumCelular);
        this.FechaInicio = FechaInicio;
        this.AñosExp = AñosExp;
    }

    public Maestro(Date FechaInicio, int AñosExp, String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, Long NumCelular, int IDMaestro)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, Edad, NumCelular);
        this.FechaInicio = FechaInicio;
        this.AñosExp = AñosExp;
        this.IDMaestro = IDMaestro;
    }

    public Maestro(String Nombre, String ApellidoPaterno, String ApellidoMaterno, int Edad, Long NumCelular, int IDMaestro, Date FechaInicio, byte[] Fotografia, int AñosExp)
    {
        super(Nombre, ApellidoPaterno, ApellidoMaterno, Edad, NumCelular);
        this.IDMaestro = IDMaestro;
        this.FechaInicio = FechaInicio;
        this.Fotografia = Fotografia;
        this.AñosExp = AñosExp;
    }

    //Metodos gett
    public Date getFechaInicio()
    {
        return FechaInicio;
    }

    public int getAñosExp()
    {
        return AñosExp;
    }

    public byte[] getFotografia()
    {
        return Fotografia;
    }

    public int getIDMaestro()
    {
        return IDMaestro;
    }

    //MetodosSet
    public void setFechaInicio(Date FechaInicio)
    {
        this.FechaInicio = FechaInicio;
    }

    public void setAñosExp(int AñosExp)
    {
        this.AñosExp = AñosExp;
    }

    public void setFotografia(byte[] Fotografia)
    {
        this.Fotografia = Fotografia;
    }

    public void setIDMaestro(int IDMaestro)
    {
        this.IDMaestro = IDMaestro;
    }

    //Metodo para mostrar lo que queremos en los combo box
    public void MostrarMaestros(JComboBox<Maestro> ComboMaestroRG)
    {
        try
        {
            Conectar ConexionMaestro = new Conectar();
            ResultSet Res = ConexionMaestro.consulta("Select * FROM maestros  ");

            while (Res.next())
                ComboMaestroRG.addItem(new Maestro(Res.getDate("FechaIngreso"), Res.getInt("Experiencia"), Res.getString("Nombre"), Res.getString("ApellidoPaterno"), Res.getString("ApellidoMaterno"), Res.getInt("Edad"), Res.getLong("Telefono"), Res.getInt("IDMaestro")));

        } catch (SQLException Ex)
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
