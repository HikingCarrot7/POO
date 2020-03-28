package cuadrilatero;

import static cuadrilatero.Punto.distanciaEntreDosPuntos;

/**
 *
 * @author Mohammed
 */
public class Romboide extends Cuadrilatero
{

    public Romboide(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        super(punto1, punto2, punto3, punto4);
    }

    public double obtenerLadoMenor()
    {
        return distanciaEntreDosPuntos(punto1, punto4);
    }

    public double obtenerLadoMayor()
    {
        return distanciaEntreDosPuntos(punto3, punto2);
    }

}
