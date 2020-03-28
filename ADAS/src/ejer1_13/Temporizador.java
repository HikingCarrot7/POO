package ejer1_13;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

/**
 *
 * @author Mohammed
 */
public class Temporizador implements Runnable
{

    private long tiempo;
    private boolean enTiempo, mostrarMensaje;
    private SesionClase sesionClase;

    public Temporizador(SesionClase sesionClase)
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

            sleep(tiempo);

            if (mostrarMensaje)
                sesionClase.seAcaboElTiempo();

            enTiempo = false;

        } catch (InterruptedException ex)
        {
            out.println(ex.getMessage());
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
