package cuadrilatero;

import static cuadrilatero.Punto.distanciaEntreDosPuntos;

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

    public double obtenerBaseMenor()
    {
        return distanciaEntreDosPuntos(punto1, punto2);
    }

    public double obtenerBaseMayor()
    {
        return distanciaEntreDosPuntos(punto3, punto4);
    }

}
