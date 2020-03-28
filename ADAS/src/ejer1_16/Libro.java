package ejer1_16;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import java.util.GregorianCalendar;

/**
 *
 * @author HikingCarrot7
 */
public class Libro extends Publicacion
{

    private GregorianCalendar anioPublicacion;
    private int nPaginas;

    public Libro(String titulo, double precio, GregorianCalendar anioPublicacion, int nPaginas)
    {
        super(titulo, precio);

        this.anioPublicacion = anioPublicacion;
        this.nPaginas = nPaginas;

    }

    public GregorianCalendar getAnioPublicacion()
    {
        return anioPublicacion;
    }

    public void setAnioPublicacion(GregorianCalendar anioPublicacion)
    {
        this.anioPublicacion = anioPublicacion;
    }

    public int getnPaginas()
    {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas)
    {
        this.nPaginas = nPaginas;
    }

    @Override
    public String toString()
    {
        String lineSeparator = getProperty("line.separator");

        return format("%-30s%-35s%-25d%s%s",
                "\"" + getTitulo() + "\"",
                format("%1$tA, %1$tB %1$td, %1$tY", anioPublicacion),
                getnPaginas(),
                format("$%,.2f", getPrecio()),
                lineSeparator);

    }

}
