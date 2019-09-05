package ada1_5;

import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class VentaCafe
{

    private Scanner in;

    public VentaCafe()
    {
        in = new Scanner(System.in);
    }

    public void venderCafe()
    {

        String kilos;
        boolean kilosValidos;

        do
        {

            kilosValidos = false;

            System.out.println("Inserte las bolsas de café que desea comprar: ");
            kilos = in.nextLine();

            if (validarEntrada(kilos, "[0-9]+"))
                if (Integer.parseInt(kilos) % 2 == 0)
                    kilosValidos = true;

                else
                    System.out.println("\nLos kilos deben ser una cantidad par\n");
            else
                System.out.println("\nCantidad inválida\n");

        } while (!kilosValidos);

        menorNumeroCajas(Integer.parseInt(kilos));
        menorNumeroEspaciosDesperdiciados(Integer.parseInt(kilos));

    }

    private void menorNumeroCajas(int kilos)
    {
        int nCajasGrandes = kilos % 20 == 0 ? kilos / 20 : kilos / 20 + 1;

        System.out.println("---------------Menor número de cajas---------------");
        System.out.println(String.format("\n\tNúmero de bolsas ordenadas: %d - $%d", kilos, kilos * 250));
        System.out.println(String.format("\nCajas grandes necesarias: %-10dEspacios remanentes: %d\n\n\t\tSu costo total es: $%d\n",
                nCajasGrandes,
                20 * nCajasGrandes - kilos,
                kilos * 250 + nCajasGrandes * 10));

    }

    private void menorNumeroEspaciosDesperdiciados(int kilos)
    {
        int temp = kilos;
        int cajasGrandes;
        int cajasMedianas;
        int cajasPequenas = 0;

        cajasGrandes = (temp - temp % 20) / 20;
        temp -= cajasGrandes * 20;

        cajasMedianas = (temp - temp % 10) / 10;
        temp -= cajasMedianas * 10;

        if (temp != 0)
            cajasPequenas = (float) temp / 5 > 1 ? 2 : 1;

        System.out.println("------Menor número de espacios desperdiciados------");
        System.out.println(String.format("\n\tNúmero de cajas ordenadas: %d - $%d", kilos, kilos * 250));
        System.out.println(String.format("\n%-25s %d\n%-25s %d\n%-25s %d\n%-25s %d\n\n\t\tSu costo total es: $%d\n",
                "Cajas grandes: ",
                cajasGrandes,
                "Cajas medianas: ", cajasMedianas,
                "Cajas pequeñas: ", cajasPequenas,
                "Espacios remanentes: ",
                cajasPequenas * 5 - temp, kilos * 250 + cajasGrandes * 10 + cajasMedianas * 5 + cajasPequenas * 3));
    }

    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
