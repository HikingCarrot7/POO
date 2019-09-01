package ada2;

import java.util.Random;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaPersona
{

    public static void main(String[] args)
    {
        Persona[] personas = new Persona[5];

        for (int i = 0; i < personas.length; i++)
        {
            personas[i] = new Persona("Nicolás", new Random().nextInt(60), "^N([a-zA-Z]){5,}s$");

            System.out.println(personas[i]);

        }

        System.out.println(validarRegex("101010101", "^1([0-1]1)*$"));

        System.out.println(validarRegex("001", "0*10*|00*"));
        
    }

    private static boolean validarRegex(String string, String regex)
    {
        return string.matches(regex);
    }
}
