package ejer1_11;

/**
 *
 * @author Mohammed
 */
public class Estudiante
{

    private TarjetaComida tarjetaComida;

    /**
     * Crea a un estudiante con su tarjeta de comida.
     *
     * @param tarjetaComida La tarjera de comida para este estudiante.
     */
    public Estudiante(TarjetaComida tarjetaComida)
    {
        this.tarjetaComida = tarjetaComida;
    }

    /**
     * Retorna la tarjeta de comida para este estudiante.
     *
     * @return La tarjeta de comida para este estudiante.
     */
    public TarjetaComida getTarjetaComida()
    {
        return tarjetaComida;
    }

    /**
     * Establece la tarjera de comida para este estudiante.
     *
     * @param tarjetaComida La nueva tarjeta de comida para este estudiante.
     */
    public void setTarjetaComida(TarjetaComida tarjetaComida)
    {
        this.tarjetaComida = tarjetaComida;
    }

}
