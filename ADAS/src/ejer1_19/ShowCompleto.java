package ejer1_19;

/**
 *
 * @author HikingCarrot7
 */
public class ShowCompleto extends Espectaculo
{

    public static final double PRECIO = 900;
    public static final double COSTOCANCELACION = 200;

    public ShowCompleto(String nombrePersonajePrincipal, int numPersonasRequeridos)
    {
        super(nombrePersonajePrincipal, numPersonasRequeridos);
    }

    public void cancelarShow()
    {
        System.out.println("Show cancelado.");
    }

}
