package com.sw.controller;

import com.sw.interfaces.InicioSesion;
import com.sw.view.AdministradoresGUI;
import com.sw.view.Login;
import com.sw.view.MaestrosGUI;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohammed
 */
public class LoginManager
{

    private final Login login;
    private final EntityManager addEntity;
    private int indexCurrentMaestro;

    public LoginManager(Login login)
    {
        this.login = login;
        addEntity = new EntityManager(login.getDataTableUpdater());
    }

    public void gestionarLogin()
    {
        if (!login.getSoyunmaestro().isEnabled() && validarLogin(login.getMaestros(), login.getUsuario().getText().trim(), login.getContrasena().getText().trim()))
        {
            MaestrosGUI.IniciarMaestrosGUI(indexCurrentMaestro, login.getMaestros(), login, addEntity);

            login.setVisible(false);

        } else if (validarLogin(login.getAdministradores(), login.getUsuario().getText().trim(), login.getContrasena().getText().trim()))
        {
            AdministradoresGUI.IniciarAdministradoresGui(login.getMaestros(), login, addEntity);

            login.setVisible(false);

        } else
            JOptionPane.showMessageDialog(login, "Los datos no son válidos", "Datos inválidos", JOptionPane.ERROR_MESSAGE);

    }

    private <T extends InicioSesion> boolean validarLogin(ArrayList<T> autoridades, String user, String password)
    {

        for (int i = 0; i < autoridades.size(); i++)
            if (autoridades.get(i).getUsuario().equals(user) && autoridades.get(i).getPassword().equals(password))
            {
                indexCurrentMaestro = i;
                return true;

            }

        return false;

    }

    public void userFieldManager()
    {
        if (!login.getUsuario().getText().trim().equals(""))
            login.getUservalido().setText(validarFormatoTexto(login.getUsuario().getText(), "^([á-úa-zA-Z._-]( ?)){9,}$") ? "" : "Usuario inválido");

    }

    public void passwordFieldManager()
    {
        if (!login.getContrasena().getText().trim().equals(""))
            login.getContravalida().setText(validarFormatoTexto(login.getContrasena().getText(), "^[a-zA-Z0-9._-]{8,}$") ? "" : "Contraseña inválida");

    }

    private boolean validarFormatoTexto(String texto, String regex)
    {
        return texto.matches(regex);
    }

    public int getIndexCurrentMaestro()
    {
        return indexCurrentMaestro;
    }

}
