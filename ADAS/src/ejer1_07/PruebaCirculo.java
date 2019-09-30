package ejer1_07;

import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class PruebaCirculo
{

    private final Scanner IN;

    public PruebaCirculo()
    {
        IN = new Scanner(System.in);
    }

    public static void main(String[] args)
    {
        new PruebaCirculo().diferenciaAreas();
    }

    /**
     * Calcula la diferencia de áreas entre dos círculos y luego muestra el resultado por consola.
     */
    public void diferenciaAreas()
    {
        double radioPrimerCirculo = pedirDato("Inserte el radio del primer círculo: ");
        double radioSegundoCirculo = pedirDato("Inserte el radio del segundo círculo: ");

        System.out.printf("\nLa diferencia de áreas es: %,.2f u%c\n",
                new Circulo(radioMayor(radioPrimerCirculo, radioSegundoCirculo)).getArea()
                - new Circulo(radioMenor(radioPrimerCirculo, radioSegundoCirculo)).getArea(), (char) 178);

    }

    /**
     * Pide los el radio de los círculos.
     *
     * @param datoAPedir Información sobre cuál radio estamos capturando.
     *
     * @return El radio del círculo capturado.
     */
    public double pedirDato(String datoAPedir)
    {
        boolean cantidadValida;
        double radioCirculo = 0;

        do
        {
            cantidadValida = false;

            System.out.println(datoAPedir);
            String entrada = IN.nextLine();

            if (validarEntrada(entrada, "^[0-9]*(.[0-9]*)?$"))
            {
                radioCirculo = Double.parseDouble(entrada);
                cantidadValida = true;

            } else
                System.out.println("\n¡Valor inválido!\n");

        } while (!cantidadValida);

        return radioCirculo;

    }

    /**
     * Determina cuál de los dos radios es el mayor (El círculo interno).
     *
     * @param x El radio del círculo 1.
     * @param y El radio del círculo 2.
     *
     * @return El radio mayor entre ambos círculos.
     */
    public double radioMayor(double x, double y)
    {
        return x > y ? x : y;
    }

    /**
     * Determina cuál de los dos radios es el menor (El círculo externo).
     *
     * @param x El radio del círculo 1.
     * @param y El radio del círculo 2.
     *
     * @return El radio menor entre ambos círculos.
     */
    public double radioMenor(double x, double y)
    {
        return x < y ? x : y;
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
    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
