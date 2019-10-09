package dominio;

/**
 *
 * @author HikingCarrot7
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

    }

    public void establecerCoordenadas(Punto punto)
    {
        punto.setX(punto.getX() < 0 || punto.getX() > 20 ? 0 : punto.getX());
        punto.setY(punto.getY() < 0 || punto.getY() > 20 ? 0 : punto.getY());

    }

    public double getArea()
    {
        return Punto.distanciaEntreDosPuntos(p3, p4) * Punto.distanciaEntreDosPuntos(p2, p4);
    }

    public double getPerimetro()
    {

        double p = 0;

        p += Punto.distanciaEntreDosPuntos(p1, p2);
        p += Punto.distanciaEntreDosPuntos(p2, p4);
        p += Punto.distanciaEntreDosPuntos(p4, p3);
        p += Punto.distanciaEntreDosPuntos(p3, p1);

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

    public boolean esCuadrado()
    {

        double distancia = Punto.distanciaEntreDosPuntos(p1, p2);

        if (distancia != Punto.distanciaEntreDosPuntos(p2, p4))
            return false;

        if (distancia != Punto.distanciaEntreDosPuntos(p3, p4))
            return false;

        return distancia == Punto.distanciaEntreDosPuntos(p1, p3);

    }

}
