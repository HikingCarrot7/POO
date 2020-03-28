package cuadrilatero;

import static cuadrilatero.Punto.distanciaEntreDosPuntos;

/**
 *
 * @author Mohammed
 */
public class Cuadrado extends Cuadrilatero
{

    public Cuadrado(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        super(punto1, punto2, punto3, punto4);
    }

    public double obtenerLongitudLado()
    {
        return distanciaEntreDosPuntos(punto3, punto4);
    }

}
