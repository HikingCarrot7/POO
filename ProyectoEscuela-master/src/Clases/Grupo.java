package Clases;

import Modulos.Maestro;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Grupo extends Horario
{

    private String TipoDeGrupo;
    private Horario Horario;
    private Maestro MaestroGrupo;
    private int IDHorario;
    private int IDMaestro;
    private String Nombre;
    private String ApellidoPaterno;
    private String ApellidoMaterno;

    private ArrayList Alumnos;
    //Constructor 

    public Grupo()
    {
    }

    public Grupo(String TipoDeGrupo, int IDHorario, String Dia, Time HoraEntrada, Time HoraSalida, int IDMaestro, String Nombre, String ApellidoPaterno, String ApellidoMaterno)
    {
        super(Dia, HoraEntrada, HoraSalida);
        this.TipoDeGrupo = TipoDeGrupo;
        this.IDHorario = IDHorario;
        this.IDMaestro = IDMaestro;
        this.Nombre = Nombre;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public Grupo(String TipoDeGrupo, int IDHorario, int IDMaestro)
    {
        this.TipoDeGrupo = TipoDeGrupo;
        this.IDHorario = IDHorario;
        this.IDMaestro = IDMaestro;
    }

    //Metodos Get
    public String getTipoDeGrupo()
    {
        return TipoDeGrupo;
    }

    public Horario getHorario()
    {
        return Horario;
    }

    public Maestro getMaestroGrupo()
    {
        return MaestroGrupo;
    }

    public ArrayList getAlumnos()
    {
        return Alumnos;
    }

    @Override
    public int getIDHorario()
    {
        return IDHorario;
    }

    public int getIDMaestro()
    {
        return IDMaestro;
    }

    public String getNombre()
    {
        return Nombre;
    }

    public String getApellidoPaterno()
    {
        return ApellidoPaterno;
    }

    public String getApellidoMaterno()
    {
        return ApellidoMaterno;
    }

    //Metodos set
    public void setTipoDeGrupo(String TipoDeGrupo)
    {
        this.TipoDeGrupo = TipoDeGrupo;
    }

    public void setHorario(Horario Horario)
    {
        this.Horario = Horario;
    }

    public void setMaestroGrupo(Maestro MaestroGrupo)
    {
        this.MaestroGrupo = MaestroGrupo;
    }

    public void setAlumnos(ArrayList Alumnos)
    {
        this.Alumnos = Alumnos;
    }

    @Override
    public void setIDHorario(int IDHorario)
    {
        this.IDHorario = IDHorario;
    }

    public void setIDMaestro(int IDMaestro)
    {
        this.IDMaestro = IDMaestro;
    }

    public void setNombre(String Nombre)
    {
        this.Nombre = Nombre;
    }

    public void setApellidoPaterno(String ApellidoPaterno)
    {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno)
    {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public void MostrarGrupos(JComboBox<Grupo> ComboGrupoRA)
    {
        try
        {
            Conectar ConexionHorarios = new Conectar();
            ResultSet Res = ConexionHorarios.consulta("Select Grupo,IDHorario,Dia,HoraEntrada,HoraSalida,IDMaestro,Nombre,ApellidoPaterno,ApellidoMaterno FROM grupos g, horario h, maestros m WHERE g.IDHorarioGrupo=h.IDHorario AND g.IDMaestroGrupo=m.IDMaestro");

            while (Res.next())
                ComboGrupoRA.addItem(new Grupo(Res.getString("Grupo"), Res.getInt("IDHorario"), Res.getString("Dia"), Res.getTime("HoraEntrada"), Res.getTime("HoraSalida"), Res.getInt("IDMaestro"), Res.getString("Nombre"), Res.getString("ApellidoPaterno"), Res.getString("ApellidoMaterno")));

        } catch (Exception Ex)
        {
            System.err.println(Ex.getMessage());
        }

    }

    @Override
    public String toString()
    {
        return "Grupo: " + getTipoDeGrupo() + " " + super.toString() + " " + getNombre() + " " + getApellidoPaterno();
    }

}
