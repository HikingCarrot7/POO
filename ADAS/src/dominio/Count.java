package dominio;

/**
 *
 * @author HikingCarrot7
 */
public class Count
{

    private final int serialNumber;
    private static int counter;

    public Count()
    {
        serialNumber = counter++;
    }

    public int getSerialNumber()
    {
        return serialNumber;
    }

    public static int getCounter()
    {
        return counter;
    }

}
