package ejer1_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class Cafeteria
{

    private final Scanner IN;
    private ArrayList<Estudiante> estudiantes;

    public Cafeteria(ArrayList<Estudiante> estudiantes)
    {
        this.estudiantes = estudiantes;
        IN = new Scanner(System.in);
    }

    public void venderAlimentos()
    {
        String entrada;

        System.out.println("\nRealizar compras para el estudiante: ");
        entrada = IN.nextLine();

        if (validarEntrada(entrada, "^[1-" + estudiantes.size() + "]$"))
            imprimirListaAlimentos();

    }

    public void imprimirListaAlimentos()
    {
        System.out.printf("\n%-20s%s\n", "<<Alimento>>", "<<Precio>>");

        for (int i = 0; i < Comida.values().length; i++)
            System.out.printf("%02d.- %-15s$%d\n", i + 1, Comida.values()[i], Comida.values()[i].getPrecio());

    }

    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
