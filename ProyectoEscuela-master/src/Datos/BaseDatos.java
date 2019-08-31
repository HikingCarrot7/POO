package Datos;

import Clases.Horario;
import Clases.PagoArticulo;
import Login.Usuario;
import Modulos.Alumno;
import Modulos.Maestro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author LuisMartinez
 */
public class BaseDatos
{

    private String bd = "bd_escuela";
    private String login = "root";
    private String password = "";
    private String url = "jdbc:mysql://localhost/" + bd;
    private Connection conn = null;
    private PreparedStatement prepSt = null;
    private ResultSet rs = null;

    public BaseDatos()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

    }

    public ArrayList<Alumno> obtenerAlumnos()
    {
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();

        try
        {

            conn = DriverManager.getConnection(url, login, password);

            String sql = "SELECT * from ingresoalumnos";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("IDAlumno");
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("ApellidoPaterno");
                String apellidoMaterno = rs.getString("ApellidoMaterno");
                int edad = rs.getInt("Edad");
                Date fecha = rs.getDate("FechaIngreso");
                Long telefono = rs.getLong("Telefono");
                byte[] foto = rs.getBytes("Foto");
                double mensualidad = rs.getDouble("Mensualidad");
                double inscripcion = rs.getDouble("Inscripcion");

                listaAlumnos.add(new Alumno(nombre, apellidoPaterno, apellidoMaterno, edad, telefono, id, fecha, foto, mensualidad, inscripcion));
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return listaAlumnos;
    }

    public void insertarPagoArticulo(PagoArticulo articulo)
    {
        try
        {
            conn = DriverManager.getConnection(url, login, password);
            String sql = "INSERT INTO pagoarticulos (IDArticulo, Articulo, Cantidad, Precio, Pago, IDAlumnoArticulos) "
                    + "values(?,?,?,?,?,?)";

            prepSt = conn.prepareStatement(sql);
            prepSt.setInt(1, articulo.getIDArticulo());
            prepSt.setString(2, articulo.getNombreArticulo());
            prepSt.setDouble(3, articulo.getNumeroArticulos());
            prepSt.setDouble(4, articulo.getPrecioArticulo());
            prepSt.setDouble(5, articulo.getPagoArticulo());
            prepSt.setInt(6, articulo.getIDAlumnoPago());

            prepSt.executeUpdate();

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<Horario> obtenerHorarios()
    {
        ArrayList<Horario> listaHorarios = new ArrayList<>();
        try
        {

            conn = DriverManager.getConnection(url, login, password);

            String sql = "SELECT * from horario";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("IDHorario");
                String dia = rs.getString("Dia");
                Time horaEntrada = rs.getTime("HoraEntrada");
                Time horaSalida = rs.getTime("HoraSalida");

                Horario horario = new Horario(id, dia, horaEntrada, horaSalida);
                listaHorarios.add(horario);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }

        }

        return listaHorarios;
    }

    public ArrayList<PagoArticulo> obtenerPagoArticulos()
    {
        ArrayList<PagoArticulo> listaPagoArticulos = new ArrayList<>();

        try
        {

            conn = DriverManager.getConnection(url, login, password);

            String sql = "SELECT * from pagoarticulos";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("IDArticulo");
                String articulo = rs.getString("Articulo");
                double cantidad = rs.getDouble("Cantidad");
                double precio = rs.getDouble("Precio");
                double pago = rs.getDouble("Pago");
                int idalumno = rs.getInt("IDAlumnoArticulos");

                listaPagoArticulos.add(new PagoArticulo(id, articulo, cantidad, precio, pago, idalumno));

            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return listaPagoArticulos;
    }

    public ArrayList<Maestro> obtenerMaestros()
    {
        ArrayList<Maestro> listaMaestros = new ArrayList<>();
        try
        {

            conn = DriverManager.getConnection(url, login, password);

            String sql = "SELECT * from maestros";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("IDMaestro");
                String nombre = rs.getString("Nombre");
                String apellidoPaterno = rs.getString("ApellidoPaterno");
                String apellidoMaterno = rs.getString("ApellidoMaterno");
                int edad = rs.getInt("Edad");
                Date fecha = rs.getDate("FechaIngreso");
                Long telefono = rs.getLong("Telefono");
                byte[] foto = rs.getBytes("Foto");
                int experiencia = rs.getInt("Experiencia");

                listaMaestros.add(new Maestro(nombre, apellidoPaterno, apellidoMaterno, edad, telefono, id, fecha, foto, experiencia));
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return listaMaestros;
    }

    public ArrayList<Usuario> obtenerUsuarios()
    {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try
        {

            conn = DriverManager.getConnection(url, login, password);

            String sql = "SELECT * from usuario";

            prepSt = conn.prepareStatement(sql);

            rs = prepSt.executeQuery();

            while (rs.next())
            {
                int id = rs.getInt("IDUsuario");
                String nombreUsuario = rs.getString("Usuario");
                String password = rs.getString("Contraseña");
                int idtipo = rs.getInt("IDTipoUsuarioU");

                Usuario usuario = new Usuario(id, nombreUsuario, password, idtipo);

                listaUsuarios.add(usuario);
            }

        } catch (SQLException ex)
        {
            ex.printStackTrace();

        } finally
        {
            try
            {
                prepSt.close();
                conn.close();

            } catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }

        return listaUsuarios;
    }

}
