/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import Clases.Conectar;
import java.sql.ResultSet;
import javax.swing.JComboBox;

/**
 *
 * @author Daniel Poot
 */
public class Usuario
{

    private int ID;
    private String Usuario;
    private String Password;
    private String Last_session;
    private int IDTipo;
    private String TipoUsuario;

    public Usuario(int IDTipo, String TipoUsuario)
    {
        this.IDTipo = IDTipo;
        this.TipoUsuario = TipoUsuario;

    }

    public Usuario(String Usuario, String Password, int IDTipo, String TipoUsuario)
    {
        this.Usuario = Usuario;
        this.Password = Password;
        this.IDTipo = IDTipo;
        this.TipoUsuario = TipoUsuario;
    }

    public Usuario()
    {
    }

    public Usuario(int ID, String Usuario, String Pasword, int IDTipo)
    {
        this.ID = ID;
        this.Usuario = Usuario;
        this.Password = Password;
        this.IDTipo = IDTipo;

    }

    public int getID()
    {
        return ID;
    }

    public void setID(int id)
    {
        this.ID = ID;
    }

    public String getUsuario()
    {
        return Usuario;
    }

    public void setUsuario(String Usuario)
    {
        this.Usuario = Usuario;
    }

    public String getPassword()
    {
        return Password;
    }

    public void setPassword(String Password)
    {
        this.Password = Password;
    }

    public String getLast_session()
    {
        return Last_session;
    }

    public void setLast_session(String Last_session)
    {
        this.Last_session = Last_session;
    }

    public int getIDTipo()
    {
        return IDTipo;
    }

    public void setIdTipo(int IDTipo)
    {
        this.IDTipo = IDTipo;
    }

    public String getTipoUsuario()
    {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario)
    {
        this.TipoUsuario = TipoUsuario;
    }

    public void MostrarUsuario(JComboBox<Usuario> ComboUsuarioRU)
    {
        try
        {
            Conectar ConexionUsuario = new Conectar();
            ResultSet Res = ConexionUsuario.consulta("Select IDTipoUsuarioU,TipoDeUsuario FROM usuario U,tipousuario T WHERE U.IDTipoUsuarioU=T.IDTipoUsuario");
            while (Res.next())
            {
                ComboUsuarioRU.addItem(new Usuario(Res.getInt("IDTipoUsuarioU"), Res.getString("TipoDeUsuario")));
            }
        } catch (Exception Ex)
        {
            System.err.println(Ex.getMessage());
        }

    }

    @Override
    public String toString()
    {
        return getTipoUsuario();
    }

}
