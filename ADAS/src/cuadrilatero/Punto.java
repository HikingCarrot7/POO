package cuadrilatero;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static java.lang.String.format;

/**
 *
 * @author Mohammed
 */
public class Punto
{

    private int x, y;

    public Punto(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public Punto()
    {
        this(0, 0);
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    @Override
    public String toString()
    {
        return format("X: %d, Y: %d", getX(), getY());
    }

    public static double distanciaEntreDosPuntos(Punto punto1, Punto punto2)
    {
        return sqrt(pow(punto2.getX() - punto1.getX(), 2) + pow(punto2.getY() - punto1.getY(), 2));
    }

}
