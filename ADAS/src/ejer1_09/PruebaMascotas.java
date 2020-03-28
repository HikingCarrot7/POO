package ejer1_09;

import static java.lang.System.out;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaMascotas
{

    public static void main(String[] args)
    {
        Gato miGato = new Gato();

        for (int i = 0; i < 10; i++)
            out.println("Hola");

        miGato.establecerNombre("Rooky");
        out.println(miGato.getNombre());
        out.println(miGato.hablar());

        out.println(new Perro().hablar());

        out.println(new Vaca().hablar());
    }

}
