package maquinacafetera;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
 */
public class MaquinaCafetera
{

    private final Scanner in;
    private final int n_billetes50, n_billetes20, n_monedas10;
    private int saldoCliente, totalVendido;
    private double gramosAzucar;

    public MaquinaCafetera(int n_billetes50, int n_billetes20, int n_monedas10)
    {
        this.n_billetes50 = n_billetes50;
        this.n_billetes20 = n_billetes20;
        this.n_monedas10 = n_monedas10;

        in = new Scanner(System.in);

    }

    public void DespacharCafe()
    {
        if (!sinDinero())
        {

            pedirDinero();

            imprimirListaCafes();

            validarCambio(obtenerEntrada());

        } else
        {
            System.out.println("Disculpe, la cafetera se quedó sin dinero!");
        }

    }

    private void pedirDinero()
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
                    saldoCliente += entrada;

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

    }

    private void imprimirListaCafes()
    {
        String puedoDarteCambio;

        System.out.println("----------Cafés disponibles----------");

        for (int i = 0; i < TiposCafe.values().length; i++)
        {
            if (TiposCafe.values()[i].getPrecio() > saldoCliente)
            {
                continue;
            }

            puedoDarteCambio = validarCambio(saldoCliente - TiposCafe.values()[i].getPrecio()) ? "" : "<No podré darte cambio>";

            System.out.printf("\n%-5s%-20sPrecio: $%-10s%s", String.valueOf(i + 1) + ".-", TiposCafe.values()[i].getTipo(), TiposCafe.values()[i].getPrecio(), puedoDarteCambio);
        }

        System.out.printf("\n\nSu saldo: $%d\nSaldo disponible en la cafetera: $%d\nGanancias de la cafetera: $%d", saldoCliente, obtenerSaldoCafetera(), totalVendido);
    }

    private int obtenerEntrada()
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
                    DespacharCafe();
                }

                valido = TiposCafe.values()[entrada - 1].getPrecio() <= obtenerSaldoCafetera();

                in.nextLine();

            } catch (InputMismatchException e)
            {
                System.out.println("No introdujiste un número válido");
            }

        } while (entrada <= 1 || entrada >= TiposCafe.values().length + 1 || !valido);

        return TiposCafe.values()[entrada - 1].getPrecio();
    }

    private boolean validarCambio(int precio)
    {

        precio = comprobarPrecio(precio, n_billetes50, 50);

        precio = comprobarPrecio(precio, n_billetes20, 20);

        precio = comprobarPrecio(precio, n_monedas10, 10);

        return precio == 0;
    }

    private int comprobarPrecio(int precio, int moneda, int valor)
    {
        if (precio >= valor && moneda != 0)
        {
            int precioBillete = precio - (precio % valor);

            precio -= ((moneda <= (precioBillete / valor)) ? (moneda * valor) : precioBillete);
        }

        return precio;
    }

    private int obtenerSaldoCafetera()
    {
        return n_billetes50 * 50 + n_billetes20 * 20 + n_monedas10 * 10;
    }

    private boolean sinDinero()
    {
        return n_billetes50 == 0 && n_billetes20 == 0 && n_monedas10 == 0;
    }
}
