package cuadrilatero;

/**
 *
 * @author Mohammed
 */
public class PruebaFiguras
{

    public static void main(String[] args)
    {
        new PruebaFiguras().ProbarFiguras();
    }

    /**
     * p1 -> +----------------+ <- p2
     *       |                |
     *       |                |
     *       |                |
     *       |                |
     * p3 -> +----------------+ <- p4
     */
    public void ProbarFiguras()
    {
        System.out.println(new Cuadrado(new Punto(-1, 0), new Punto(0, 0), new Punto(-1, -1), new Punto(0, -1)).obtenerArea());

        System.out.println(new Trapecio(new Punto(1, 2), new Punto(3, 2), new Punto(0, 0), new Punto(4, 0)).obtenerArea());

        System.out.println(new Romboide(new Punto(0, 0), new Punto(2, 3), new Punto(2, -2), new Punto(4, 0)).obtenerArea());

    }

}
