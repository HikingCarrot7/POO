package ada_static;

/**
 *
 * @author HikingCarrot7
 */
public class TestCounter extends Count
{

    public static void main(String[] args)
    {
        System.out.println("El contador es: " + Count.getCounter());

        Count count = new Count();

        System.out.println("El contador es: " + Count.getCounter());

    }

}
