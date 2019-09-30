package ejer1_07;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class Circulo
{

    private double radio; // Radio de este círculo.

    /**
     * Constructor de la clase círculo.
     *
     * @param radio El radio inicial para este círculo.
     */
    public Circulo(double radio)
    {
        this.radio = radio;
    }

    public Circulo()
    {
        this(5);
    }

    /**
     * Retorna el área de este círculo.
     *
     * @return El área de este círculo.
     */
    public double getArea()
    {
        return Math.PI * radio * radio;
    }

    /**
     * Retorna el perímetro de este círculo.
     *
     * @return El perímetro de este círculo.
     */
    public double getPerimetro()
    {
        return Math.PI * radio * 2;
    }

    /**
     * Retorna el radio de este círculo.
     *
     * @return El radio de este círculo.
     */
    public double getRadio()
    {
        return radio;
    }

    /**
     * Establece el radio de este círculo.
     *
     * @param radio El nuevo radio para este círculo.
     */
    public void setRadio(double radio)
    {
        this.radio = radio;
    }

}
