package ada1_5;

import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class VentaCafe
{

    private final Scanner in;

    public VentaCafe()
    {
        in = new Scanner(System.in);
    }

    public void venderCafe()
    {

        String bolsas;
        boolean bolsasValidas;

        do
        {

            bolsasValidas = false;

            System.out.println("Inserte las bolsas de café que desea comprar: ");
            bolsas = in.nextLine();

            if (validarEntrada(bolsas, "[0-9]+"))
                if (Integer.parseInt(bolsas) % 2 == 0)
                    bolsasValidas = true;

                else
                    System.out.println("\nLas bolsas deben ser una cantidad par\n");
            else
                System.out.println("\nCantidad inválida\n");

        } while (!bolsasValidas);

        menorNumeroCajas(Integer.parseInt(bolsas));
        menorNumeroEspaciosDesperdiciados(Integer.parseInt(bolsas));

    }

    private void menorNumeroCajas(int bolsas)
    {
        int nCajasGrandes = bolsas % 20 == 0 ? bolsas / 20 : bolsas / 20 + 1;

        System.out.println("---------------Menor número de cajas---------------");
        System.out.println(String.format("\n\tNúmero de bolsas ordenadas: %d - $%d", bolsas, bolsas * 250));
        System.out.println(String.format("\nCajas grandes necesarias: %-10dEspacios remanentes: %d\n\n\t\tSu costo total es: $%d\n",
                nCajasGrandes,
                20 * nCajasGrandes - bolsas,
                bolsas * 250 + nCajasGrandes * 10));

    }

    private void menorNumeroEspaciosDesperdiciados(int bolsas)
    {
        int tempBolsas = bolsas;
        int cajasGrandes;
        int cajasMedianas;
        int cajasPequenas = 0;

        cajasGrandes = (tempBolsas - tempBolsas % 20) / 20;
        tempBolsas -= cajasGrandes * 20;

        cajasMedianas = (tempBolsas - tempBolsas % 10) / 10;
        tempBolsas -= cajasMedianas * 10;

        if (tempBolsas != 0)
            cajasPequenas = (float) tempBolsas / 5 > 1 ? 2 : 1;

        System.out.println("-----Menor número de espacios desaprovechados-----");
        System.out.println(String.format("\n\tNúmero de cajas ordenadas: %d - $%d", bolsas, bolsas * 250));
        System.out.println(String.format("\n%-25s %d\n%-25s %d\n%-25s %d\n%-25s %d\n\n\t\tSu costo total es: $%d\n",
                "Cajas grandes: ",
                cajasGrandes,
                "Cajas medianas: ", cajasMedianas,
                "Cajas pequeñas: ", cajasPequenas,
                "Espacios remanentes: ",
                cajasPequenas * 5 - tempBolsas, bolsas * 250 + cajasGrandes * 10 + cajasMedianas * 5 + cajasPequenas * 3));
    }

    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
