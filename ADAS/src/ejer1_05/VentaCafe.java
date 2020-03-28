package ejer1_05;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 * Clase VentaCafe.
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class VentaCafe
{

    private final Scanner IN;
    private final DespachoCajas ventaCafe;

    public static void main(String[] args)
    {
        new VentaCafe().pedirBolsas();
    }

    public VentaCafe()
    {
        IN = new Scanner(in);
        ventaCafe = new DespachoCajas();

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

            out.println("Inserte las bolsas de café que desea comprar: "); // Pedimos las bolsas.
            bolsas = IN.nextLine();

            if (validarEntrada(bolsas, "^[0-9]+$")) // Validamos por medio de una expresión regular si el número de bolsas insertado es correcto. (Aún no conocemos las excepciones).
                bolsasValidas = true;
            else
                out.println("\nCantidad inválida\n");

        } while (!bolsasValidas);

        ventaCafe.calcularMenorNumeroCajas(parseInt(bolsas)); // Calculamos el menor número de cajas para el empaquetado.
        ventaCafe.calcularMenorNumeroEspaciosDesperdiciados(parseInt(bolsas)); // Calculamos el menor número de espacios desperdiciados.

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
