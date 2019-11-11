package ejer1_21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author HikingCarrot7
 */
public class DataManager implements ActionListener
{

    public DataManager(VistaPrincipal vista)
    {
        vista.getArea().addActionListener(this);
        vista.getPerimetro().addActionListener(this);
        vista.getVolumen().addActionListener(this);

    }

    public void mostrarPerimetro(JTextField entradaRadio, JTextField resultado)
    {

        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().getPerimetro(Double.parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarArea(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().getArea(Double.parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarVolumen(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(String.format("%s", new Circulo().getVolumen(Double.parseDouble(entradaRadio.getText()))));

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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());

        switch (e.getActionCommand())
        {
            case "Área":
                System.out.println("Hola");

        }
    }

}
