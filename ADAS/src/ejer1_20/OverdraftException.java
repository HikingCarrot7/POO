package ejer1_20;

/**
 *
 * @author Mohammed
 */
public class OverdraftException extends Exception
{

    private double deficit;

    public OverdraftException(String message, double deficit)
    {
        super(String.format("\n->%s$%,.2f\n", message, deficit));
    }

    public OverdraftException()
    {

    }

    public OverdraftException(String message, Throwable e)
    {
        super(message, e);
    }

    public OverdraftException(String message)
    {
        super(message);
    }

    public double getDeficit()
    {
        return deficit;
    }

}
