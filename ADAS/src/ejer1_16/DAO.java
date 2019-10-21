package ejer1_16;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

/**
 *
 * @author HikingCarrot7
 */
public class DAO
{

    private final String ruta = "res/RegistroDistribuidora.txt";
    private final File file;

    public DAO() throws IOException
    {
        file = new File(ruta);

        if (!file.exists())
            file.createNewFile();

    }

    public void escribirRegistro(Disco[] discos, Libro[] libros) throws IOException
    {

        String lineSeparator = System.getProperty("line.separator");
        String registro = String.format("%s%s%2$s", "Libros:", lineSeparator);

        for (Disco disco : discos)
            registro += String.format("\t\t%s", disco);

        registro += String.format("%s%s%2$s", "Discos:", lineSeparator);

        for (Libro libro : libros)
            registro += String.format("\t\t%s", libro);

        try (Formatter out = new Formatter(new FileWriter(ruta, false)))
        {

        }

    }

}
