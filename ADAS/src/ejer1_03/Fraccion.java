package ejer1_03;

/**
 *
 * @author Mohammed
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
        setDenomimador(fraccion.getDenominador());
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

    public Fraccion suma(Fraccion otraFraccion)
    {
        return new Fraccion(getNumerador() * otraFraccion.getDenominador() + getDenominador() * otraFraccion.getNumerador(), getDenominador() * otraFraccion.getDenominador());
    }

    public Fraccion suma(int numero)
    {
        return new Fraccion(getNumerador() + numero * getDenominador(), getDenominador());
    }

    public Fraccion resta(Fraccion otraFraccion)
    {
        return new Fraccion(getNumerador() * otraFraccion.getDenominador() - getDenominador() * otraFraccion.getNumerador(), getDenominador() * otraFraccion.getDenominador());
    }

    public Fraccion resta(int numero)
    {
        return new Fraccion(getNumerador() - numero * getDenominador(), getDenominador());
    }

    public Fraccion multiplica(Fraccion otraFraccion)
    {
        return new Fraccion(getNumerador() * otraFraccion.getNumerador(), getDenominador() * otraFraccion.getDenominador());
    }

    public Fraccion multiplica(int numero)
    {
        return new Fraccion(getNumerador() * numero, getDenominador());
    }

    public Fraccion divide(Fraccion otraFraccion)
    {
        return new Fraccion(getNumerador() * otraFraccion.getDenominador(), getDenominador() * otraFraccion.getNumerador());
    }

    public Fraccion divide(int numero)
    {
        return new Fraccion(getNumerador(), getDenominador() * numero);
    }

    public Fraccion simplifica()
    {
        int mcd = 1;

        if (getNumerador() != 0 && getDenominador() != 0)
            mcd = mcd(getNumerador(), getDenominador());

        return new Fraccion(getNumerador() / mcd, getDenominador() / mcd);
    }

    public int getNumerador()
    {
        return numerador;
    }

    public void setNumerador(int numerador)
    {
        this.numerador = numerador;
    }

    public int getDenominador()
    {
        return denominador;
    }

    public void setDenomimador(int denominador)
    {
        if (denominador == 0)
        {
            System.err.println("Error, el denominador no puede ser 0");
            System.exit(1);
        }

        this.denominador = denominador;
    }

    @Override
    public String toString()
    {
        return String.format("%d / %d", getNumerador(), getDenominador());
    }

}
