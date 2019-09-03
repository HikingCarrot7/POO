package ada1_4;

import java.util.ArrayList;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaBicicleta
{

    private final ArrayList<Bicicleta> bicicletas;

    public PruebaBicicleta()
    {
        bicicletas = new ArrayList<>();
    }

    private void RegistrarBicicleta()
    {
        bicicletas.add(new Bicicleta("UERTW", "Nicolás Canul", "9991676253"));
        bicicletas.add(new Bicicleta("SDFDF", "Javier Chim", "9991679867"));
        bicicletas.add(new Bicicleta("IRTRW", "Emmanuel Chable", "9991645333"));

        for (Bicicleta bicicleta : bicicletas)
            System.out.println(bicicleta.mostrarDatos());

    }

    public static void main(String[] args)
    {
        new PruebaBicicleta().RegistrarBicicleta();
    }

}
