package ada1_8;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaMascotas
{

    public static void main(String[] args)
    {
        Gato miGato = new Gato();

        miGato.establecerNombre("Rooky");
        System.out.println(miGato.getNombre());
        System.out.println(miGato.hablar());

        System.out.println(new Perro().hablar());

        System.out.println(new Vaca().hablar());

    }

}
