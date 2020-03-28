package ejer1_16;

import java.io.IOException;
import static java.lang.Math.random;
import java.util.GregorianCalendar;

/**
 *
 * @author Mohammed
 */
public class PruebaDistribuidora
{

    private Distribuidora distribuidora;
    private DAO dao;

    public PruebaDistribuidora() throws IOException
    {
        distribuidora = new Distribuidora();
        dao = new DAO();

    }

    public void rellenarPublicaciones() throws IOException
    {

        for (int i = 0; i < 10; i++)
        {
            distribuidora.addDisco("Disco " + (i + 1), 500 + random() * 1000, 20 + (int) (random() * 100));

            distribuidora.addLibro("Libro " + (i + 1), 400 + random() * 1000,
                    new GregorianCalendar((int) (1950 + random() * 100), (int) (1 + random() * 11), (int) (1 + random() * 30)),
                    50 + (int) (random() * 100));

        }

        generarRegistro();

    }

    public void generarRegistro() throws IOException
    {
        dao.escribirRegistro(distribuidora.getDiscos(), distribuidora.getLibros());
    }

    public static void main(String[] args) throws IOException
    {
        new PruebaDistribuidora().rellenarPublicaciones();
    }

}
