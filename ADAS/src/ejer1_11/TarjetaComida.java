package ejer1_11;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class TarjetaComida
{

    private int saldoTarjeta; // Saldo.

    /**
     * Crea una tarjeta de comida con los puntos especificados.
     *
     * @param saldoTarjeta Los puntos para esta nueva tarjeta de comida.
     */
    public TarjetaComida(int saldoTarjeta)
    {
        this.saldoTarjeta = saldoTarjeta;
    }

    /**
     * Establece 100 puntos por defecto para esta tarjeta de comida.
     */
    public TarjetaComida()
    {
        this(100);
    }

    /**
     * Retorna el saldo de esta tarjeta.
     *
     * @return El saldo de esta tarjeta.
     */
    public int getSaldoTarjeta()
    {
        return saldoTarjeta;
    }

    /**
     * Establece el saldo para esta tarjeta.
     *
     * @param saldoTarjeta El nuevo saldo para esta tarjeta.
     */
    public void setSaldoTarjeta(int saldoTarjeta)
    {
        this.saldoTarjeta = saldoTarjeta;
    }

}
