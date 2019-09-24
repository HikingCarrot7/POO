package ada1_4;

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

            System.out.println("\nInserte su nombre:");
            String nombre = in.nextLine();

            System.out.println("\nInserte su número de teléfono:");
            String telefono = in.nextLine();

            registrados.add(new Bicicleta(nombre, telefono));

        }

        imprimirRegistrados();

    }

    public void imprimirRegistrados()
    {
        for (Bicicleta registro : registrados)
            System.out.println(registro);

    }

    public static void main(String[] args)
    {
        new PruebaBicicleta().registrarBicicleta();
    }

}
