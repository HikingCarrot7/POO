package ejer1_17;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class Menu
{

    private final Scanner IN;
    private GestorDatos gestorDatos;

    public Menu() throws IOException
    {
        IN = new Scanner(System.in);
        gestorDatos = new GestorDatos();

    }

    public void imprimirMenu()
    {

        System.out.println("Seleccione una opción:\n"
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
                System.out.println("Opción inválida.\n");

        } while (!opcionValida);

    }

    private int leerMes()
    {
        boolean mesValido;
        String entrada;

        do
        {

            System.out.println("Inserte el mes:");
            entrada = IN.nextLine();

            mesValido = validarEntrada(entrada, "^[0-9]+$") && Integer.parseInt(entrada) >= 1 && Integer.parseInt(entrada) <= 12;

        } while (!mesValido);

        return Integer.parseInt(entrada);

    }

    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
