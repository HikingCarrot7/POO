package ejer1_19;

import static java.lang.System.out;

/**
 *
 * @author HikingCarrot7
 */
public abstract class Espectaculo implements Show
{

    protected String nombrePersonajePrincipal;
    protected int numPersonasRequeridos;
    protected static int numEspectaculosTotales = 0;

    public Espectaculo(String nombrePersonajePrincipal, int numPersonasRequeridos)
    {
        this.nombrePersonajePrincipal = nombrePersonajePrincipal;
        this.numPersonasRequeridos = numPersonasRequeridos;

        numEspectaculosTotales++;

    }

    @Override
    public void regalarPremios()
    {
        out.println("Se están regalando premios con temática de: " + getNombrePersonajePrincipal());
    }

    @Override
    public void presentarCoreografia()
    {
        out.println("Se está presentando una coreografía con temática de:" + getNombrePersonajePrincipal());
    }

    @Override
    public void terminarConcuso()
    {
        out.println("Se ha terminado el concurso.");
    }

    public String getNombrePersonajePrincipal()
    {
        return nombrePersonajePrincipal;
    }

    public void setNombrePersonajePrincipal(String nombrePersonajePrincipal)
    {
        this.nombrePersonajePrincipal = nombrePersonajePrincipal;
    }

    public int getNumPersonasRequeridos()
    {
        return numPersonasRequeridos;
    }

    public void setNumPersonasRequeridos(int numPersonasRequeridos)
    {
        this.numPersonasRequeridos = numPersonasRequeridos;
    }

    public static int getNumEspectaculosTotales()
    {
        return numEspectaculosTotales;
    }

}
