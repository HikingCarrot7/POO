package ejer1_19;

import static java.lang.String.format;
import java.util.Calendar;

/**
 *
 * @author HikingCarrot7
 */
public class Agenda
{

    private Calendar fecha;
    private Espectaculo espectaculo;

    public Agenda(Calendar fecha, Espectaculo espectaculo)
    {
        this.fecha = fecha;
        this.espectaculo = espectaculo;

    }

    public Calendar getFecha()
    {
        return fecha;
    }

    public void setFecha(Calendar fecha)
    {
        this.fecha = fecha;
    }

    public Espectaculo getEspectaculo()
    {
        return espectaculo;
    }

    public void setEspectaculo(Espectaculo espectaculo)
    {
        this.espectaculo = espectaculo;
    }

    @Override
    public String toString()
    {
        return format("%-30s%-35s$%,.2f",
                getEspectaculo().nombrePersonajePrincipal,
                format("%1$tA, %1$tB %1$td, %1$tY", fecha),
                getEspectaculo() instanceof ShowBasico ? ShowBasico.PRECIO : ShowCompleto.PRECIO);

    }

}
