package Clases;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

public class Conectar
{

    static String bd = "bd_escuela";
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/" + bd;
    Connection connection = null;

    public Conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, password);
            
            if (connection != null)
                System.out.println("Conexión a base de datos " + bd + " OK\n");
            
        } catch (SQLException | ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getConnection()
    {
        return connection;
    }

    public void Desconectar()
    {
        try
        {
            System.out.println("Cerrando conexion");
            connection.close();

        } catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    //Metodo Para Reutilizar y solo colocar la consulta SQL dentro de los metodos de las demas tablas
    public ResultSet consulta(String sql)
    {
        ResultSet Res = null;
        try
        {

            PreparedStatement Pstm = connection.prepareStatement(sql);
            Res = Pstm.executeQuery();

        } catch (SQLException ex)
        {
            System.err.println("Error consulta : " + ex.getMessage());
        }

        return Res;
    }

    //Metodo para obtener los datos de la BD
    public DefaultComboBoxModel Obt_Grupos()
    {
        DefaultComboBoxModel IngreGrupoRA = new DefaultComboBoxModel();
        IngreGrupoRA.addElement("Seleccione un grupo");
        ResultSet Res = this.consulta("Select * FROM Grupos order by Grupo");

        try
        {
            while (Res.next())
                IngreGrupoRA.addElement(Res.getString("Grupo"));

            Res.close();

        } catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

        return IngreGrupoRA;
    }

}
