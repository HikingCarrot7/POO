package cannon;

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
        IN = new Scanner(System.in);
    }

    public void pedirDatos()
    {
        System.out.println("Inserte el ángulo inicial: ");
        double anguloInicial = IN.nextDouble();

        System.out.println("\nInserte la velocidad inicial: ");
        double velocidadInicial = IN.nextDouble();

        new Cannon(velocidadInicial, anguloInicial);

    }

}
