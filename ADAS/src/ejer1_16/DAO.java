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
        String registro = String.format("%s%s%2$s", "Discos:", lineSeparator);

        registro += String.format("%-30s%-35s%s%s%4$s", "Título", "Duración (minutos)", "Precio", lineSeparator);

        for (Disco disco : discos)
            registro += String.format("%s", disco);

        registro += String.format("%2$s%s%s%2$s", "Libros:", lineSeparator);

        registro += String.format("%-30s%-35s%-25s%s%s%5$s", "Título", "Año de publicación", "Número de páginas", "Precio", lineSeparator);

        for (Libro libro : libros)
            registro += String.format("%s", libro);

        try (Formatter out = new Formatter(new FileWriter(new File(ruta))))
        {
            out.format("%s", registro);
        }

        System.out.println(registro);

    }

}
