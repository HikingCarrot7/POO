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
        Fraccion fraccion2 = new Fraccion(1, 3);

        System.out.println(fraccion1.suma(fraccion2).simplifica());

        System.out.println(fraccion1.resta(fraccion2).simplifica());

        System.out.println(fraccion1.multiplica(fraccion2).simplifica());

        System.out.println(fraccion1.divide(fraccion2).simplifica());

    }
}
