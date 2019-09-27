package ejer1_11;

/**
 *
 * @author Mohammed
 */
public class TarjetaComida
{

    private int saldoTarjeta;

    public TarjetaComida(int saldoTarjeta)
    {
        this.saldoTarjeta = saldoTarjeta;
    }

    public TarjetaComida()
    {
        this(100);
    }

    public int getSaldoTarjeta()
    {
        return saldoTarjeta;
    }

    public void setSaldoTarjeta(int saldoTarjeta)
    {
        this.saldoTarjeta = saldoTarjeta;
    }

}
