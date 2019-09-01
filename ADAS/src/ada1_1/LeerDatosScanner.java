package ada1_1;

import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
 */
public class LeerDatosScanner
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Escribe tu nombre:");

        System.out.printf("\nHola %s, bienvenido a la programación en Java!\n", in.nextLine());

    }

}
