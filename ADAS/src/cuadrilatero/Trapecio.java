package cuadrilatero;

/**
 *
 * @author Mohammed
 */
public class Trapecio extends Cuadrilatero
{

    public Trapecio(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        super(punto1, punto2, punto3, punto4);
    }

    @Override
    public double obtenerArea()
    {
        return (obtenerBase() + obtenerBaseMenor()) * obtenerAltura() / 2;
    }

    @Override
    public double obtenerBase()
    {
        return Punto.distanciaEntreDosPuntos(punto3, punto4);
    }

    @Override
    public double obtenerAltura()
    {
        return 1;
    }

    public double obtenerBaseMenor()
    {
        return Punto.distanciaEntreDosPuntos(punto1, punto2);
    }

}
