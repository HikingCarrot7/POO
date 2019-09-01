package ada1_1;

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
        System.out.println("Escribe tu nombre:");

        //Imprimimos en pantalla una frase con el String que se insertó por el usuario anteriormente.
        System.out.printf("\nHola %s, bienvenido a la programación en Java!\n", in.nextLine());

    }//Fin del main.

}//Fin de la clase LeerDatosScanner.
