package Clases;

import java.sql.ResultSet;
import java.sql.Time;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Horario
{

    private String Dia;
    private java.sql.Time HoraEntrada;
    private java.sql.Time HoraSalida;
    private int IDHorario;

    //Contructor
    public Horario()
    {
    }

    public Horario(int IDHorario, String Dia, Time HoraEntrada, Time HoraSalida)
    {
        this.Dia = Dia;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
        this.IDHorario = IDHorario;
    }

    public Horario(String Dia, Time HoraEntrada, Time HoraSalida)
    {
        this.Dia = Dia;
        this.HoraEntrada = HoraEntrada;
        this.HoraSalida = HoraSalida;
    }

    public String getDia()
    {
        return Dia;
    }

    public Time getHoraEntrada()
    {
        return HoraEntrada;
    }

    public Time getHoraSalida()
    {
        return HoraSalida;
    }

    public void setDia(String Dia)
    {
        this.Dia = Dia;
    }

    public int getIDHorario()
    {
        return IDHorario;
    }

    public void setHoraEntrada(Time HoraEntrada)
    {
        this.HoraEntrada = HoraEntrada;
    }

    public void setHoraSalida(Time HoraSalida)
    {
        this.HoraSalida = HoraSalida;
    }

    public void setIDHorario(int IDHorario)
    {
        this.IDHorario = IDHorario;
    }

    public void MostrarHorarios(JComboBox<Horario> ComboHorarioRG)
    {
        try
        {
            Conectar ConexionHorarios = new Conectar();
            ResultSet Res = ConexionHorarios.consulta("Select * FROM horario ");

            while (Res.next())
                ComboHorarioRG.addItem(new Horario(Res.getInt("IDHorario"), Res.getString("Dia"), Res.getTime("HoraEntrada"), Res.getTime("HoraSalida")));

        } catch (Exception Ex)
        {
            System.err.println(Ex.getMessage());
        }

    }

    @Override
    public String toString()
    {
        return Dia + " E: " + HoraEntrada + " S: " + HoraSalida;
    }

}
