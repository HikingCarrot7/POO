package ejer1_04;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaBicicleta
{

    private final Scanner in;
    private final ArrayList<Bicicleta> registrados;

    public PruebaBicicleta()
    {
        in = new Scanner(System.in);
        registrados = new ArrayList<>();
    }

    public void registrarBicicleta()
    {
        for (int i = 0; i < 3; i++)
        {
            out.println("\nInserte su nombre:");
            String nombre = in.nextLine();

            out.println("\nInserte su número de teléfono:");
            String telefono = in.nextLine();

            registrados.add(new Bicicleta(nombre, telefono));
        }

        imprimirRegistrados();
    }

    public void imprimirRegistrados()
    {
        for (Bicicleta registro : registrados)
            out.println(registro);
    }

    public static void main(String[] args)
    {
        new PruebaBicicleta().registrarBicicleta();
    }

}
