package ejer1_12;

import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
 */
public class IniciaJuegoFermi
{

    private Scanner IN;
    private String[] pistas;
    private JuegoFermi fermi;
    private int[] numerosUsuario;

    public IniciaJuegoFermi()
    {
        IN = new Scanner(in);
        numerosUsuario = new int[3];
        fermi = new JuegoFermi();
    }

    public static void main(String[] args)
    {

        new IniciaJuegoFermi().jugar();

    }

    public void jugar()
    {
        int jugadas = 0;
        boolean gana = false;

        while (!gana)
        {
            for (int i = 0; i < 3; i++)
            {
                out.println("\nDigite el número: " + (i + 1));
                numerosUsuario[i] = IN.nextInt();
            }

            out.printf("\nSus números:%6d  %5d  %5d", numerosUsuario[0], numerosUsuario[1], numerosUsuario[2]);

            pistas = fermi.obtenerPistasNumerosEntrada(numerosUsuario);

            out.printf("\nPistas:%11s  %5s  %5s\n", pistas[0], pistas[1], pistas[2]);

            jugadas++;

            gana = fermi.jugadorGana();

        }

        out.printf("\n\nGanaste con %d jugadas\n", jugadas);

    }

}
