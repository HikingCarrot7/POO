package ejer1_17;

import java.io.IOException;
import static java.lang.Math.random;
import static java.lang.String.format;
import static java.lang.System.out;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public final class GestorDatos
{

    private Anio anio;
    private DAO dao;

    public GestorDatos() throws IOException
    {
        anio = new Anio();
        dao = new DAO(anio);

        if (dao.temperaturasRegistradas())
            anio.setMeses(dao.leerTemperaturas());

        else
            generarTempDias();

    }

    private void generarTempDias() throws IOException
    {
        double[] tempsMes;

        for (int i = 0; i < anio.getDiasMeses().length; i++)
        {
            tempsMes = new double[anio.getDiasMeses()[i]];

            for (int j = 0; j < tempsMes.length; j++)
                tempsMes[j] = random() * 100 - 50;

            anio.getMeses()[i].setTempDias(tempsMes);

        }

        dao.escribirTemperaturas(anio.getMeses());

    }

    public void mediaTemperaturasMensuales()
    {

        out.println("\n<------Media de las temperaturas mensuales.------>\n");

        out.println(format("%-15s%s", "Mes", "Media de la temperatura"));

        for (int i = 0; i < anio.getMeses().length; i++)
            out.println(format("%-15s%,.2f", anio.getNombreMeses()[i], anio.getMeses()[i].getMediaTemperaturaMes()));

    }

    public void mediaTemperaturaAnual()
    {
        out.println("\n<------Media de la temperatura anual.------>\n");

        out.println(format("%-15s%,.2f", "Media anual:", anio.getMediaAnual()));

    }

    public void temperaturaMaxYMinMes(int mes)
    {
        out.println("\n<------Temperatura máxima y mínima del mes de " + anio.getNombreMeses()[mes - 1].toLowerCase() + ".------>\n");

        out.println(format("%-25s%,.2f\n%-25s%,.2f",
                "Temperatura máxima:", anio.getMaxTempMes(mes),
                "Temperatura mínima:", anio.getMinTempMes(mes)));

    }

}
