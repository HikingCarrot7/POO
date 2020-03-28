package ejemplofechas;

import static ejemplofechas.Fecha.ordenarFechas;
import static java.lang.System.out;
import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class UsoFechas
{

    public static void main(String[] args)
    {
        Random rand = new Random();
        Fecha[] fechas = new Fecha[10];

        out.println("Fechas: ");

        for (int i = 0; i < 10; i++)
        {
            fechas[i] = new Fecha(5 + rand.nextInt(20), 1 + rand.nextInt(12), 2000 + rand.nextInt(30));

            out.println(fechas[i]);
        }

        out.println("\nFechas ordenadas:");

        fechas = ordenarFechas(fechas);

        for (int i = 0; i < 10; i++)
            out.println(fechas[i]);

    }

}
