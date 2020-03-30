package ejer1_0;

import static java.lang.System.out;

/**
 * Esta clase hace una pequeña analogía de una impresora que nos muestra en consola un mensaje que le pasamos como parámetro.
 *
 * @author Mohammed
 *
 * @since 1.0
 */
public class Impresora
{

    /**
     * Imprime en consola el mensaje que le pasemos como parámetro.
     *
     * @param mensaje El mensaje a imprimir en la consola.
     *
     * @since 1.0
     */
    public void imprimir(String mensaje)
    {
        out.println(mensaje);
    }

}
