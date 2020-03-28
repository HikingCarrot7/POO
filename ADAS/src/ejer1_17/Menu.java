package ejer1_17;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class Menu
{

    private final Scanner IN;
    private final GestorDatos gestorDatos;

    public Menu() throws IOException
    {
        IN = new Scanner(in);
        gestorDatos = new GestorDatos();

    }

    public void imprimirMenu()
    {

        out.println("Seleccione una opción:\n"
                + "1.- Para mostrar la media mensual de cada mes\n"
                + "2.- Para mostrar la media anual\n"
                + "3.- Para mostrar la temperatura máxima o mínima de un mes");

    }

    public void leerEntrada()
    {
        boolean opcionValida;
        String entrada;

        do
        {
            entrada = IN.nextLine();
            opcionValida = validarEntrada(entrada, "^[1-3]$");

            if (opcionValida)
                switch (entrada)
                {
                    case "1":
                        gestorDatos.mediaTemperaturasMensuales();
                        break;

                    case "2":
                        gestorDatos.mediaTemperaturaAnual();
                        break;

                    case "3":
                        gestorDatos.temperaturaMaxYMinMes(leerMes());
                        break;
                }

            else
                out.println("Opción inválida.\n");

        } while (!opcionValida);

    }

    private int leerMes()
    {
        boolean mesValido;
        String entrada;

        do
        {
            out.println("Inserte el mes:");
            entrada = IN.nextLine();

            mesValido = validarEntrada(entrada, "^[0-9]+$") && parseInt(entrada) >= 1 && parseInt(entrada) <= 12;

        } while (!mesValido);

        return parseInt(entrada);
    }

    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
