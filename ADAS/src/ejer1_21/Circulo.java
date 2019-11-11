package ejer1_21;

/**
 *
 * @author HikingCarrot7
 */
public class Circulo
{

    public double getArea(double radio)
    {
        return Math.PI * radio * radio;
    }

    public double getPerimetro(double radio)
    {
        return Math.PI * radio * 2;
    }

    public double getVolumen(double radio)
    {
        return (4 / 3) * Math.PI * Math.pow(radio, 3);
    }

}
