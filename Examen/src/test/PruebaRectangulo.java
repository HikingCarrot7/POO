package test;

import dominio.Punto;
import dominio.Rectangulo;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class PruebaRectangulo
{

    /**
     * p1 -> (0, 2)*-------------* (5, 2) <- p2
     *             |             |
     *             |             |
     * p3 -> (0, 0)*-------------* (5, 0) <- p4
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //                               p1               p2               p3               p4
        Rectangulo rect = new Rectangulo(new Punto(0, 2), new Punto(5, 2), new Punto(0, 0), new Punto(5, 0));

        System.out.println("\nDatos de este rectángulo:\n");

        System.out.println(rect.esCuadrado() ? "Es un cuadrado." : "No es un cuadrado.");

        System.out.println("\nLongitud:");

        System.out.println(rect.getLongitud() + " u");

        System.out.println("\nAnchura:");

        System.out.println(rect.getAnchura() + " u");

        System.out.println("\nPerímetro:");

        System.out.println(rect.getPerimetro() + " u");

        System.out.println("\nÁrea:");

        System.out.println(rect.getArea() + String.valueOf(" u" + (char) 178));

    }

}
