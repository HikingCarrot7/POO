package ejer1_21;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.exit;
import static java.lang.System.out;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.OK_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;
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
            resultado.setText(format("%s", new Circulo().getPerimetro(parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarArea(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(format("%s", new Circulo().getArea(parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void mostrarVolumen(JTextField entradaRadio, JTextField resultado)
    {
        if (validarEntrada(entradaRadio.getText(), "^[0-9]+(.?[0-9]+)?$"))
            resultado.setText(format("%s", new Circulo().getVolumen(parseDouble(entradaRadio.getText()))));

        else
            mostrarError();

    }

    public void salir()
    {
        exit(1);
    }

    private void mostrarError()
    {
        showMessageDialog(null, "La entrada no es válida", "Entrada no válida", OK_OPTION);
    }

    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        out.println(e.getActionCommand());

        switch (e.getActionCommand())
        {
            case "Área":
                out.println("Hola");

        }
    }

}
