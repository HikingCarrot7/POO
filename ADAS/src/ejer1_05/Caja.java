package ejer1_05;

/**
 *
 * Clase Caja.
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class Caja
{

    private final String TIPO;
    private final int CAPACIDAD;
    private final double PRECIO;

    /**
     * Constructor de la clase caja.
     *
     * @param TIPO El identificador de la caja.
     * @param CAPACIDAD La capacidad de la caja.
     * @param PRECIO El precio de la caja.
     */
    public Caja(String TIPO, int CAPACIDAD, double PRECIO)
    {
        this.TIPO = TIPO;
        this.CAPACIDAD = CAPACIDAD;
        this.PRECIO = PRECIO;

    }

    /**
     * Retorna el tipo de la caja.
     *
     * @return El tipo de la caja.
     */
    public String getTIPO()
    {
        return TIPO;
    }

    /**
     * Retorna la capacidad de la caja.
     *
     * @return La capacidad de la caja.
     */
    public int getCAPACIDAD()
    {
        return CAPACIDAD;
    }

    /**
     * Retorna el precio de la caja.
     *
     * @return El precio de la caja.
     */
    public double getPRECIO()
    {
        return PRECIO;
    }

}
