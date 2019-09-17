package cuadrilatero;

/**
 *
 * @author Nicolás
 */
public abstract class Cuadrilatero
{

    protected Punto punto1, punto2, punto3, punto4;

    public Cuadrilatero(Punto punto1, Punto punto2, Punto punto3, Punto punto4)
    {
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.punto3 = punto3;
        this.punto4 = punto4;

    }

    public Punto getPunto1()
    {
        return punto1;
    }

    public void setPunto1(Punto punto1)
    {
        this.punto1 = punto1;
    }

    public Punto getPunto2()
    {
        return punto2;
    }

    public void setPunto2(Punto punto2)
    {
        this.punto2 = punto2;
    }

    public Punto getPunto3()
    {
        return punto3;
    }

    public void setPunto3(Punto punto3)
    {
        this.punto3 = punto3;
    }

    public Punto getPunto4()
    {
        return punto4;
    }

    public void setPunto4(Punto punto4)
    {
        this.punto4 = punto4;
    }

    public abstract double obtenerArea();

    public abstract double obtenerBase();

    public abstract double obtenerAltura();

}
