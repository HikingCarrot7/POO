package cuadrilatero;

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
        return Punto.distanciaEntreDosPuntos(punto1, punto4);
    }

    public double obtenerLadoMayor()
    {
        return Punto.distanciaEntreDosPuntos(punto3, punto2);
    }

}
