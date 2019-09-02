package ada1_3;

/**
 *
 * @author HikingCarrot7
 */
public final class Fraccion
{

    private int numerador, denominador;

    public Fraccion()
    {
        this(0);
    }

    public Fraccion(int num)
    {
        setNumerador(num);
        setDenomimador(1);
    }

    public Fraccion(Fraccion fraccion)
    {
        setNumerador(fraccion.getNumerador());
        setDenomimador(fraccion.getDemonnimador());
    }

    public Fraccion(int numerador, int denominador)
    {
        setDenomimador(denominador);
        setNumerador(numerador);
    }

    public int mcd(int m, int n)
    {
        int r = n % m;

        while (r != 0)
        {
            n = m;
            m = r;
            r = n % m;
        }

        return m;
    }

    public Fraccion simplifica()
    {
        int mcd = mcd(getNumerador(), getDemonnimador());

        return new Fraccion(getNumerador() / mcd, getDemonnimador() / mcd);
    }

    public Fraccion suma(Fraccion otraFraccion)
    {
        return new Fraccion(getNumerador() * otraFraccion.getDemonnimador() + getDemonnimador() * otraFraccion.getNumerador(), getDemonnimador() * otraFraccion.getDemonnimador());
    }

    public Fraccion suma(int numero)
    {
        return new Fraccion(getNumerador() + numero * getDemonnimador(), getDemonnimador());
    }

    public int getNumerador()
    {
        return numerador;
    }

    public void setNumerador(int numerador)
    {
        this.numerador = numerador;
    }

    public int getDemonnimador()
    {
        return denominador;
    }

    public void setDenomimador(int demonnimador)
    {
        this.denominador = demonnimador;
    }

    @Override
    public String toString()
    {
        return String.format("%d / %d", getNumerador(), getDemonnimador());
    }

}
