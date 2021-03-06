package ejer1_01;

import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class LeerDatosScanner
{

    /**
     *
     * @param args Los argumentos recuperados de la consola.
     *
     * @since 1.0
     */
    public static void main(String[] args)
    {
        //Objeto Scanner para leer los datos del teclado.
        Scanner in = new Scanner(System.in);

        //Pedimos un String al usuario.
        out.println("Escribe tu nombre:");

        //Imprimimos en pantalla una frase con el String que se insertó por el usuario anteriormente.
        out.printf("\nHola %s, bienvenido a la programación en Java!\n", in.nextLine());

    }//Fin del main.

}//Fin de la clase LeerDatosScanner.
