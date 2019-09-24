package ada1_8;

/**
 *
 * @author HikingCarrot7
 */
public abstract class Mascota
{

    protected String nombre;

    protected String getNombre()
    {
        return nombre;
    }

    public void establecerNombre(String nombre)
    {
        this.nombre = nombre;
    }

    protected abstract String hablar();

}
