package ejer1_11;

/**
 *
 * @author Mohammed
 */
public class Estudiante
{

    private TarjetaComida tarjetaComida;

    public Estudiante(TarjetaComida tarjetaComida)
    {
        this.tarjetaComida = tarjetaComida;
    }

    public TarjetaComida getTarjetaComida()
    {
        return tarjetaComida;
    }

    public void setTarjetaComida(TarjetaComida tarjetaComida)
    {
        this.tarjetaComida = tarjetaComida;
    }

}
