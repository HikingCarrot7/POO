package ejer1_03;

import static java.lang.System.out;

/**
 *
 * @author Mohammed
 */
public class PruebaFraccion
{

    public static void main(String[] args)
    {

        Fraccion fraccion1 = new Fraccion(3, 5);
        Fraccion fraccion2 = new Fraccion(2, 5);

        out.printf("%36s\n", "<Suma>");
        out.printf("%-25s%s con %-10s es: %s\n\n", "La suma de: ", fraccion1, fraccion2, fraccion1.suma(fraccion2).simplifica());

        out.printf("%36s\n", "<Resta>");
        out.printf("%-25s%s con %-10s es: %s\n\n", "La resta de: ", fraccion1, fraccion2, fraccion1.resta(fraccion2).simplifica());

        out.printf("%41s\n", "<Multiplicación>");
        out.printf("%-25s%s con %-10s es: %s\n\n", "La multiplicación de: ", fraccion1, fraccion2, fraccion1.multiplica(fraccion2).simplifica());

        out.printf("%38s\n", "<División>");
        out.printf("%-25s%s con %-10s es: %s\n\n", "La división de: ", fraccion1, fraccion2, fraccion1.divide(fraccion2).simplifica());

    }
}
