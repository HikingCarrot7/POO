package ejer1_17;

import java.io.IOException;

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
                tempsMes[j] = Math.random() * 100 - 50;

            anio.getMeses()[i].setTempDias(tempsMes);

        }

        dao.escribirTemperaturas(anio.getMeses());

    }

    public void mediaTemperaturasMensuales()
    {

        System.out.println("\n<------Media de las temperaturas mensuales.------>\n");

        System.out.println(String.format("%-15s%s", "Mes", "Media de la temperatura"));

        for (int i = 0; i < anio.getMeses().length; i++)
            System.out.println(String.format("%-15s%,.2f", anio.getNombreMeses()[i], anio.getMeses()[i].getMediaTemperaturaMes()));

    }

    public void mediaTemperaturaAnual()
    {
        System.out.println("\n<------Media de la temperatura anual.------>\n");

        System.out.println(String.format("%-15s%,.2f", "Media anual:", anio.getMediaAnual()));

    }

    public void temperaturaMaxYMinMes(int mes)
    {
        System.out.println("\n<------Temperatura máxima y mínima del mes de " + anio.getNombreMeses()[mes - 1].toLowerCase() + ".------>\n");

        System.out.println(String.format("%-25s%,.2f\n%-25s%,.2f",
                "Temperatura máxima:", anio.getMaxTempMes(mes),
                "Temperatura mínima:", anio.getMinTempMes(mes)));

    }

}
