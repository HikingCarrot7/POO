package ejer1_21;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

/**
 *
 * @author HikingCarrot7
 */
public class Circulo
{

    public double getArea(double radio)
    {
        return PI * radio * radio;
    }

    public double getPerimetro(double radio)
    {
        return PI * radio * 2;
    }

    public double getVolumen(double radio)
    {
        return (4 / 3) * PI * pow(radio, 3);
    }

}
