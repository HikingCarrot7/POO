package ejer1_20;

import static java.lang.String.format;

/**
 *
 * @author Mohammed
 */
public class OverdraftException extends Exception
{

    private double deficit;

    public OverdraftException(String message, double deficit)
    {
        super(format("\n->%s$%,.2f\n", message, deficit));
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
