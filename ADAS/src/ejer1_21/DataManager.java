package ejer1_21;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HikingCarrot7
 */
public class DataManager
{

    public void mostrarPerimetro(JTextField entradaRadio, JTextField resultado)
    {

        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().perimetro(Double.parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarArea(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().area(Double.parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarVolumen(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().volumen(Double.parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void salir()
    {
        System.exit(1);
    }

    private void mostrarError()
    {
        JOptionPane.showMessageDialog(null, "La entrada no es válida", "Entrada no válida", JOptionPane.OK_OPTION);
    }

    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
