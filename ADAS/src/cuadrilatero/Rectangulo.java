package cuadrilatero;

import static cuadrilatero.Punto.distanciaEntreDosPuntos;

/**
 *
 * @author Mohammed
 */
public class Rectangulo extends Cuadrilatero
{

    public Rectangulo(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        super(punto1, punto2, punto3, punto4);
    }

    public double obtenerBase()
    {
        return distanciaEntreDosPuntos(punto3, punto4);
    }

    public double obtenerAltura()
    {
        return distanciaEntreDosPuntos(punto4, punto2);
    }

}
