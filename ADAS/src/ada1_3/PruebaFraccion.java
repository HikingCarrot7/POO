package ada1_3;

/**
 *
 * @author Mohammed
 */
public class PruebaFraccion
{

    public static void main(String[] args)
    {
        Fraccion fraccion1 = new Fraccion(1, 2);
        Fraccion fraccion2 = new Fraccion(2, 5);

        System.out.printf("%36s\n", "<Suma>");
        System.out.printf("%-25s%s con %-10s es: %s\n\n", "La suma de: ", fraccion1, fraccion2, fraccion1.suma(fraccion2).simplifica());

        System.out.printf("%36s\n", "<Resta>");
        System.out.printf("%-25s%s con %-10s es: %s\n\n", "La resta de: ", fraccion1, fraccion2, fraccion1.resta(fraccion2).simplifica());

        System.out.printf("%41s\n", "<Multiplicación>");
        System.out.printf("%-25s%s con %-10s es: %s\n\n", "La multiplicación de: ", fraccion1, fraccion2, fraccion1.multiplica(fraccion2).simplifica());

        System.out.printf("%38s\n", "<División>");
        System.out.printf("%-25s%s con %-10s es: %s\n\n", "La división de: ", fraccion1, fraccion2, fraccion1.divide(fraccion2).simplifica());

    }
}
