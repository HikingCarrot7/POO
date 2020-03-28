package cuadrilatero;

import static java.lang.String.format;
import static java.lang.System.out;

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

        out.println(format("%-35s %,.2f u^2", "El área de este cuadrado es:", new Cuadrado(new Punto(-1, 0), new Punto(0, 0), new Punto(-1, -1), new Punto(0, -1)).obtenerArea()));

        out.println(format("%-35s %,.2f u^2", "El área de este rectángulo es:", new Rectangulo(new Punto(0, 2), new Punto(3, 2), new Punto(0, 0), new Punto(3, 0)).obtenerArea()));

        out.println(format("%-35s %,.2f u^2", "El área de este trapecio es:", new Trapecio(new Punto(1, 2), new Punto(3, 2), new Punto(0, 0), new Punto(4, 0)).obtenerArea()));

        out.println(format("%-35s %,.2f u^2", "El área de este rombiode es:", new Romboide(new Punto(0, 0), new Punto(2, 3), new Punto(2, -2), new Punto(4, 0)).obtenerArea()));

    }

}
