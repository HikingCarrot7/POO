package cannon;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class Usuario
{

    private final Scanner IN;

    public Usuario()
    {
        IN = new Scanner(in);
    }

    public void pedirDatos()
    {
        out.println("Inserte el ángulo inicial: ");
        double anguloInicial = IN.nextDouble();

        out.println("\nInserte la velocidad inicial: ");
        double velocidadInicial = IN.nextDouble();

        new Cannon(velocidadInicial, anguloInicial);

    }

}
