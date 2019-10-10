package test;

import dominio.Punto;
import dominio.Rectangulo;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaRectangulo
{

    /**
     * p1 -> *-------------* <- p2
     *       |             |
     *       |             |
     * p3 -> *-------------* <- p4
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Rectangulo rect = new Rectangulo(new Punto(0, 2), new Punto(4, 2), new Punto(0, 0), new Punto(4, 0));

        System.out.println("\nEs cuadrado:");

        System.out.println(rect.esCuadrado());

        System.out.println("\nLongitud: ");

        System.out.println(rect.getLongitud());

        System.out.println("\nAnchura");

        System.out.println(rect.getAnchura());

        System.out.println("\nPerímetro");

        System.out.println(rect.getPerimetro());

        System.out.println("\nÁrea");

        System.out.println(rect.getArea());

    }

}
