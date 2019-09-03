package ada1_4;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaBicicleta
{

    private final Bicicleta[] bicicletas =
    {
        new Bicicleta("UERTW", "Nicolás Canul", "9991676253"),
        new Bicicleta("SDFDF", "Javier Chim", "9991679867"),
        new Bicicleta("IRTRW", "Emmanuel Chable", "9991645333")

    };

    private void registrarBicicleta()
    {

        for (Bicicleta bicicleta : bicicletas)
            System.out.println(bicicleta.mostrarDatos());

    }

    public static void main(String[] args)
    {
        new PruebaBicicleta().registrarBicicleta();
    }

}
