package cannon;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.String.format;
import static java.lang.System.out;
import static java.lang.Thread.sleep;

/**
 *
 * @author Mohammed
 */
public class Cannon implements Runnable
{

    private final double GRAVEDAD = 9.8;
    private final double velInicial, anguloInicial;

    public Cannon(double velInicial, double anguloInicial)
    {
        this.velInicial = velInicial;
        this.anguloInicial = anguloInicial;

        new Thread(this).start();

    }

    @Override
    public void run()
    {
        int tiempo = 0;

        while (true)

            try
            {
                sleep(1000);

                if (valorY(tiempo) < 0)
                    break;

                out.println(format("\nTiempo: %d segundo(s)\n%s", tiempo, posicionEnXTiempo(valorX(tiempo), valorY(tiempo))));

                tiempo++;

            } catch (InterruptedException ex)
            {
                out.println(ex.getMessage());
            }

    }

    private Punto posicionEnXTiempo(double x, double y)
    {
        return new Punto(x, y);
    }

    private double valorX(int tiempo)
    {
        return velInicial * cos(gradosToRadians(anguloInicial)) * tiempo;
    }

    private double valorY(int tiempo)
    {
        return (velInicial * sin(gradosToRadians(anguloInicial))) * tiempo - (GRAVEDAD * pow(tiempo, 2) / 2);
    }

    /**
     * Convierte un ángulo en grados a radianes.
     *
     * @param grados El ángulo en grados.
     * @return El ángulo en radianes.
     */
    private double gradosToRadians(double grados)
    {
        return grados * PI / 180;
    }

    private class Punto
    {

        private double x, y;

        public Punto(double x, double y)
        {
            this.x = x;
            this.y = y;
        }

        public Punto()
        {
            this(0, 0);
        }

        public double getX()
        {
            return x;
        }

        public void setX(double x)
        {
            this.x = x;
        }

        public double getY()
        {
            return y;
        }

        public void setY(double y)
        {
            this.y = y;
        }

        @Override
        public String toString()
        {
            return format("Valor de X: %,.2f, valor de Y: %,.2f", getX(), getY());
        }

    }

}
