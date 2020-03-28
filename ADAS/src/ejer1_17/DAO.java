package ejer1_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Double.parseDouble;
import static java.lang.String.format;
import static java.lang.System.getProperty;
import java.util.Formatter;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class DAO
{

    private String ruta = "res/TemperaturasAnuales.txt";
    private File file;
    private Anio anio;

    public DAO(Anio anio) throws IOException
    {
        file = new File(ruta);

        if (!file.exists())
            file.createNewFile();

        this.anio = anio;

    }

    public Mes[] leerTemperaturas() throws FileNotFoundException
    {
        int indexMeses = 0;
        Mes[] meses = new Mes[12];

        for (int i = 0; i < meses.length; i++)
            meses[i] = new Mes(anio.getDiasMeses()[i]);

        try (Scanner in = new Scanner(new FileReader(file)))
        {
            while (in.hasNextLine())
            {
                int i = 0;
                String aux = in.nextLine();

                StringTokenizer temps = new StringTokenizer(aux, ",");
                double[] tempsMes = new double[temps.countTokens()];

                while (temps.hasMoreTokens())
                    tempsMes[i++] = parseDouble(temps.nextToken());

                meses[indexMeses++].setTempDias(tempsMes);

            }

        }

        return meses;

    }

    public void escribirTemperaturas(Mes[] meses) throws IOException
    {
        String lineSeparator = getProperty("line.separator");
        String todasTemps = "";

        try (Formatter out = new Formatter(new FileWriter(file, false)))
        {
            for (Mes mes : meses)
                todasTemps += format("%s%s", mes, lineSeparator);

            out.format("%s", todasTemps);

        }

    }

    public boolean temperaturasRegistradas() throws FileNotFoundException
    {
        return new Scanner(new FileReader(ruta)).hasNextLine();
    }

}
