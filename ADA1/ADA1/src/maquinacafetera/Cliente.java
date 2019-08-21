package maquinacafetera;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
 */
public class Cliente
{

    private final Scanner in;
    private final Cafetera cafetera;
    private int dineroCliente;

    public Cliente(Cafetera cafetera)
    {
        in = new Scanner(System.in);

        this.cafetera = cafetera;
    }

    public void InsertarDinero()
    {
        boolean terminar = false;

        do
        {

            try
            {

                System.out.println("\nInserte su dinero (billetes de 50, billetes de 20, monedas de 10) ");
                int entrada = in.nextInt();

                if (entrada == 10 || entrada == 20 || entrada == 50)
                {
                    dineroCliente += entrada;

                } else
                {
                    throw new InputMismatchException();
                }

                in.nextLine();

            } catch (InputMismatchException e)
            {
                System.out.println("\nMoneda no válida. Inténtalo de nuevo");
            }

            System.out.println("\n¿Insertará más dinero? (Si o No)");

            if (in.next().equalsIgnoreCase("no"))
            {
                terminar = true;
            }

            in.nextLine();

        } while (!terminar);

        cafetera.setSaldoCliente(dineroCliente);

        cafetera.despacharCafe();

    }

    public int obtenerOpcionProducto()
    {
        int entrada = 0;
        boolean valido = true;

        do
        {
            try
            {
                System.out.println("\n\nInserte una opción: (Presione 4 para cancelar la operación)");
                entrada = in.nextInt();

                if (entrada == 4)
                {
                    //maquinaCafetera.despacharCafe();
                }

                valido = TiposCafe.values()[entrada - 1].getPrecio() <= cafetera.obtenerSaldoCafetera();

                in.nextLine();

            } catch (InputMismatchException e)
            {
                System.out.println("No introdujiste un número válido");
            }

        } while (entrada < 1 || entrada > TiposCafe.values().length || !valido);

        return entrada - 1;
    }

    public int obtenerNivelAzucar()
    {
        return 1;
    }
}
