package ejer1_13;

/**
 *
 * @author Mohammed
 */
public class Cronometro implements Runnable
{

    private long tiempo;
    private boolean enTiempo, mostrarMensaje;
    private SesionClase sesionClase;

    public Cronometro(SesionClase sesionClase)
    {
        this.sesionClase = sesionClase;
    }

    public void iniciarTemporizador(long tiempo)
    {
        this.tiempo = tiempo;
        enTiempo = true;
        mostrarMensaje = true;

        new Thread(this).start();

    }

    @Override
    public void run()
    {
        try
        {

            Thread.sleep(tiempo);

            if (mostrarMensaje)
                sesionClase.seAcaboElTiempo();

            enTiempo = false;

        } catch (InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }

    }

    public boolean isMostrarMensaje()
    {
        return mostrarMensaje;
    }

    public void setMostrarMensaje(boolean mostrarMensaje)
    {
        this.mostrarMensaje = mostrarMensaje;
    }

    public boolean enTiempo()
    {
        return enTiempo;
    }

}
