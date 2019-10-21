package ejer1_16;

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

}
