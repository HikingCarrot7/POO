package com.sw.controller;

import com.sw.view.Interfaz;

/**
 *
 * @author Mohammed
 */
public class DataManager
{

    private final Interfaz interfaz;

    private DataManager(Interfaz interfaz)
    {
        this.interfaz = interfaz;
    }

    public void updateCampos()
    {

        int baseEntrada = Integer.parseInt((String) interfaz.getEntradaOpcion().getSelectedItem());
        int baseSalida = Integer.parseInt((String) interfaz.getSalidaOpcion().getSelectedItem());
        String entrada = interfaz.getEntrada().getText();

        if (baseEntrada != 16)
            if (validarBase(interfaz.getEntrada().getText(), "^[0-" + (baseEntrada - 1) + "]$"))
            {

            } else
                interfaz.getValorInvalido().setText("¡Valor inválido!");

    }

    private boolean validarBase(String text, String regex)
    {
        return text.matches(regex);
    }

}
