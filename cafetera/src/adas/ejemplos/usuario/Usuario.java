package adas.ejemplos.usuario;

import adas.ejemplos.maquina.Cafetera;
import adas.ejemplos.maquina.ContenedorMonedas;
import adas.ejemplos.productos.TiposCafe;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author GrajalesMag
 */
public class Usuario
{

    private int saldoCliente = 0;
    private final Scanner in;
    private final Cafetera cafetera;
    private final ContenedorMonedas contenedorGanancias;

    public Usuario(Cafetera cafetera, ContenedorMonedas contenedorGanancias)
    {
        in = new Scanner(System.in);

        this.cafetera = cafetera;
        this.contenedorGanancias = contenedorGanancias;
    }

    public void InsertarDinero() throws IOException
    {
        boolean terminar = false, insertarMasDinero = true;

        do
        {

            try
            {

                System.out.println("\nInserte su dinero (billetes de 50, billetes de 20, monedas de 10) ");
                int entrada = in.nextInt();

                switch (entrada)
                {
                    case 10:

                        contenedorGanancias.setN_monedas10(contenedorGanancias.getN_monedas10() + 1);
                        saldoCliente += 10;

                        break;

                    case 20:

                        contenedorGanancias.setN_monedas20(contenedorGanancias.getN_monedas20() + 1);
                        saldoCliente += 20;

                        break;

                    case 50:

                        contenedorGanancias.setN_monedas50(contenedorGanancias.getN_monedas50() + 1);
                        saldoCliente += 50;

                        break;

                    default:

                        throw new InputMismatchException();

                }

                in.nextLine();

            } catch (InputMismatchException e)
            {
                System.out.println("\nMoneda no válida. Inténtalo de nuevo");

                insertarMasDinero = false;

            }

            if (insertarMasDinero)
            {
                System.out.println("\n¿Insertará más dinero? (Sí o No)");

                if (in.next().equalsIgnoreCase("no"))
                {
                    terminar = true;
                }

            }

            in.nextLine();
            
            insertarMasDinero = true;

        } while (!terminar);

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
                    cafetera.retirarDinero(contenedorGanancias, saldoCliente);

                    return 4;

                }

                valido = (saldoCliente - TiposCafe.values()[entrada - 1].getPrecio()) <= cafetera.obtenerSaldoCafetera();

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
        int entrada = 0;
        boolean azucarValida = false;

        do
        {
            try
            {
                System.out.println("\nInserte un nivel de azúcar o presione 0 para un café sin azúcar");
                entrada = in.nextInt();

                if (entrada < 0 || entrada > 3)
                {
                    throw new InputMismatchException();
                }

                azucarValida = true;

            } catch (InputMismatchException e)
            {
                System.out.println("\nNivel de azúcar o entrada no válida");
            }

        } while (!azucarValida);

        return entrada;
    }

    public int getSaldoCliente()
    {
        return saldoCliente;
    }

    public void setSaldoCliente(int saldoCliente)
    {
        this.saldoCliente = saldoCliente;
    }
}
