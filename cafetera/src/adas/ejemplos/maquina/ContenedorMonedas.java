package adas.ejemplos.maquina;

/**
 *
 * @author GrajalesMag
 */
public class ContenedorMonedas
{

    private int n_monedas50, n_monedas20, n_monedas10;

    public ContenedorMonedas(int n_monedas50, int n_monedas20, int n_monedas10)
    {
        if (n_monedas50 < 0 || n_monedas20 < 0 || n_monedas10 < 0)
        {
            throw new MonedaInvalida();
        }

        this.n_monedas50 = n_monedas50;
        this.n_monedas20 = n_monedas20;
        this.n_monedas10 = n_monedas10;
    }

    public ContenedorMonedas()
    {
        this(0, 0, 0);
    }

    public int getN_monedas50()
    {
        return n_monedas50;
    }

    public void setN_monedas50(int n_monedas50)
    {
        if (n_monedas50 < 0)
        {
            throw new MonedaInvalida();
        }

        this.n_monedas50 = n_monedas50;
    }

    public int getN_monedas20()
    {
        return n_monedas20;
    }

    public void setN_monedas20(int n_monedas20)
    {
        if (n_monedas20 < 0)
        {
            throw new MonedaInvalida();
        }

        this.n_monedas20 = n_monedas20;
    }

    public int getN_monedas10()
    {
        return n_monedas10;
    }

    public void setN_monedas10(int n_monedas10)
    {
        if (n_monedas10 < 0)
        {
            throw new MonedaInvalida();
        }

        this.n_monedas10 = n_monedas10;
    }

    public int getTotal()
    {
        return n_monedas50 * 50 + n_monedas20 * 20 + n_monedas10 * 10;
    }

    @Override
    public String toString()
    {
        String lineSeparator = System.getProperty("line.separator");
        
        return String.format("%4$s%s%4$s%s%4$s%s%4$s", "Monedas de 50: " + n_monedas50, "Monedas de 20: " + n_monedas20, "Monedas de 10: " + n_monedas10, lineSeparator);
    }

    private class MonedaInvalida extends RuntimeException
    {

        public MonedaInvalida()
        {
            this("\nLa cantidad de monedas no es válida");
        }

        public MonedaInvalida(String text)
        {
            super(text);
        }

        public MonedaInvalida(String text, Throwable e)
        {
            super(text, e);
        }

    }
}
