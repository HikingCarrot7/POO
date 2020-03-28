package ejer1_16;

import static java.lang.String.format;
import static java.lang.System.getProperty;

/**
 *
 * @author HikingCarrot7
 */
public class Disco extends Publicacion
{

    private int duracionMin;

    public Disco(String titulo, double precio, int duracionMin)
    {
        super(titulo, precio);

        this.duracionMin = duracionMin;

    }

    public int getDuracionMin()
    {
        return duracionMin;
    }

    public void setDuracionMin(int duracionMin)
    {
        this.duracionMin = duracionMin;
    }

    @Override
    public String toString()
    {
        String lineSeparator = getProperty("line.separator");

        return format("%-30s%-35d%s%s",
                "\"" + getTitulo() + "\"",
                getDuracionMin(),
                format("$%,.2f", getPrecio()),
                lineSeparator);

    }

}
