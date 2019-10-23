package ejer1_19;

import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class PruebaEspectaculo
{

    private Empresa empresa;
    private final Random RAND;

    public PruebaEspectaculo()
    {
        empresa = new Empresa();

        RAND = new Random();

    }

    public static void main(String[] args)
    {
        new PruebaEspectaculo().rellenarAgenda();
    }

    public void rellenarAgenda()
    {

        for (int i = 0; i < 20; i++)
            empresa.agregarNuevoEspectaculoAgendado(new Agenda(generarFecha(), empresa.getEspectaculos().get(RAND.nextInt(6))));

        empresa.reporteEspectaculo();

    }

    private GregorianCalendar generarFecha()
    {
        return new GregorianCalendar(2000 + RAND.nextInt(20), RAND.nextInt(11), RAND.nextInt(31));
    }

}
