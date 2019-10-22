package ejer1_19;

/**
 *
 * @author HikingCarrot7
 */
public class ShowBasico extends Espectaculo
{

    public ShowBasico(String nombrePersonajePrincipal, int numPersonasRequeridos)
    {
        super(nombrePersonajePrincipal, numPersonasRequeridos);
    }

    @Override
    public void regalarPremios()
    {
        System.out.println("Se están regalando premios con temática de: " + getNombrePersonajePrincipal());
    }

    @Override
    public void presentarCoreografia()
    {
        System.out.println("Se está presentando una coreografía con temática de:" + getNombrePersonajePrincipal());
    }

    @Override
    public void terminarConcuso()
    {
        System.out.println("Se ha terminado el concurso.");
    }

}
