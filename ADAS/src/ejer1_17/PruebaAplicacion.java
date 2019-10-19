package ejer1_17;

import java.io.IOException;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class PruebaAplicacion
{

    public static void main(String[] args) throws IOException
    {
        Menu menu = new Menu();

        while (!false)
        {
            menu.imprimirMenu();

            menu.leerEntrada();

            System.out.println("\n\n");

        }

    }

}
