package dominio;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public final class Rectangulo
{

    private Punto p1;
    private Punto p2;
    private Punto p3;
    private Punto p4;

    public Rectangulo(Punto p1, Punto p2, Punto p3, Punto p4)
    {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        establecerCoordenadas(p1);
        establecerCoordenadas(p2);
        establecerCoordenadas(p3);
        establecerCoordenadas(p4);

        noEsRectangulo();

    }

    private void establecerCoordenadas(Punto punto)
    {
        punto.setX(punto.getX() < 0 || punto.getX() > 20 ? 0 : punto.getX());
        punto.setY(punto.getY() < 0 || punto.getY() > 20 ? 0 : punto.getY());

    }

    public boolean esCuadrado()
    {
        return Punto.distanciaEntreDosPuntos(p1, p2) == Punto.distanciaEntreDosPuntos(p2, p4);
    }

    private boolean esRombo()
    {
        return esCuadrado() && (p1.getY() < p2.getY() || p1.getY() > p2.getY());
    }

    public void noEsRectangulo()
    {
        if (Punto.distanciaEntreDosPuntos(p2, p4) != Punto.distanciaEntreDosPuntos(p1, p3)
                || Punto.distanciaEntreDosPuntos(p1, p4) != Punto.distanciaEntreDosPuntos(p2, p3)
                || p1 == p3 || p2 == p4 || esRombo())
        {
            System.err.println("\nEste objeto no es un rectángulo\n");
            System.exit(1);

        }

    }

    public double getArea()
    {
        return Punto.distanciaEntreDosPuntos(p3, p4) * Punto.distanciaEntreDosPuntos(p2, p4);
    }

    public double getPerimetro()
    {

        double p = 0;

        p += Punto.distanciaEntreDosPuntos(p1, p2) * 2;
        p += Punto.distanciaEntreDosPuntos(p2, p4) * 2;

        return p;

    }

    public double getLongitud()
    {
        double ladoMayor = Punto.distanciaEntreDosPuntos(p1, p2);

        if (Punto.distanciaEntreDosPuntos(p1, p2) < Punto.distanciaEntreDosPuntos(p2, p4))
            ladoMayor = Punto.distanciaEntreDosPuntos(p2, p4);

        return ladoMayor;

    }

    public double getAnchura()
    {
        double anchura = Punto.distanciaEntreDosPuntos(p1, p2);

        if (anchura > Punto.distanciaEntreDosPuntos(p2, p4))
            anchura = Punto.distanciaEntreDosPuntos(p2, p4);

        return anchura;

    }

    public Punto getP1()
    {
        return p1;
    }

    public void setP1(Punto p1)
    {
        this.p1 = p1;
    }

    public Punto getP2()
    {
        return p2;
    }

    public void setP2(Punto p2)
    {
        this.p2 = p2;
    }

    public Punto getP3()
    {
        return p3;
    }

    public void setP3(Punto p3)
    {
        this.p3 = p3;
    }

    public Punto getP4()
    {
        return p4;
    }

    public void setP4(Punto p4)
    {
        this.p4 = p4;
    }

}
