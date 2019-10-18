package ejer1_17;

import java.io.IOException;

/**
 *
 * @author Mohammed
 */
public final class PruebaAplicacion
{

    private Anio anio;
    private DAO dao;

    public PruebaAplicacion() throws IOException
    {
        anio = new Anio();
        dao = new DAO(anio);

        if (dao.temperaturasRegistradas())
            anio.setMeses(dao.leerTemperaturas());

        else
            generarTempDias();
    }

    public void generarTempDias() throws IOException
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

    public void imprimirTemps()
    {
        for (Mes mes : anio.getMeses())
            System.out.println(mes);

    }

    public static void main(String[] args) throws IOException
    {
        new PruebaAplicacion().imprimirTemps();
    }

}
