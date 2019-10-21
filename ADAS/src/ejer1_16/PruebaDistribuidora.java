package ejer1_16;

import java.io.IOException;
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
            distribuidora.addDisco("Disco " + (i + 1), 500 + Math.random() * 1000, 20 + (int) (Math.random() * 100));

            distribuidora.addLibro("Libro " + (i + 1), 400 + Math.random() * 1000,
                    new GregorianCalendar((int) (1950 + Math.random() * 100), (int) (1 + Math.random() * 11), (int) (1 + Math.random() * 30)),
                    50 + (int) (Math.random() * 100));

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
