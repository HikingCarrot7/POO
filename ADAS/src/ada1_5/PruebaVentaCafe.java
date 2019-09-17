package ada1_5;

import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class PruebaVentaCafe
{

    private final Scanner IN;
    private final VentaCafe ventaCafe;

    public static void main(String[] args)
    {
        new PruebaVentaCafe().pedirBolsas();
    }

    public PruebaVentaCafe()
    {
        IN = new Scanner(System.in);
        ventaCafe = new VentaCafe();

    }

    /**
     * Pide las bolsas para realizar los cálculos correspondientes.
     */
    public void pedirBolsas()
    {
        String bolsas;
        boolean bolsasValidas;

        do
        {

            bolsasValidas = false;

            System.out.println("Inserte las bolsas de café que desea comprar: "); // Pedimos las bolsas.
            bolsas = IN.nextLine();

            if (validarEntrada(bolsas, "^[0-9]+$")) // Validamos por medio de una expresión regular si el número de bolsas insertado es correcto. (Aún no conocemos las excepciones).
                bolsasValidas = true;
            else
                System.out.println("\nCantidad inválida\n");

        } while (!bolsasValidas);

        ventaCafe.calcularMenorNumeroCajas(Integer.parseInt(bolsas)); // Calculamos el menor número de cajas para el empaquetado.
        ventaCafe.calcularMenorNumeroEspaciosDesperdiciados(Integer.parseInt(bolsas)); // Calculamos el menor número de espacios desperdiciados.

    }

    /**
     * Valida si el texto especificado concuerda con la expresión regular especificada.
     *
     * @param text El texto a validar.
     * @param regex La expresión regular.
     *
     * @return <code>true</code> el texto concuerda con la expresión regular o <code>false</code> en caso contrario.
     *
     */
    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
