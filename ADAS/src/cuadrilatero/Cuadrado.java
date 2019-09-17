package cuadrilatero;

/**
 *
 * @author Nicolás
 */
public class Cuadrado extends Cuadrilatero
{

    public Cuadrado(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        super(punto1, punto2, punto3, punto4);
    }

    @Override
    public double obtenerArea()
    {
        return obtenerBase() * obtenerAltura();
    }

    @Override
    public double obtenerBase()
    {
        return Punto.distanciaEntreDosPuntos(punto3, punto4);
    }

    @Override
    public double obtenerAltura()
    {
        return Punto.distanciaEntreDosPuntos(punto2, punto4);
    }

}
