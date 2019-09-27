package ejer1_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class Registro
{

    private final Scanner IN;
    private ArrayList<Estudiante> estudiantes;

    public Registro()
    {
        estudiantes = new ArrayList<>();
        IN = new Scanner(System.in);

    }

    public void registrarEstudiantes()
    {

        boolean seguirRegistrandoEstudiantes;
        String entrada;

        do
        {
            seguirRegistrandoEstudiantes = true;

            System.out.println("\nInserte el saldo de la tarjeta de comida para este estudiante.\n(presione \"enter\" para cancelar o \"0\" si no desea insertarle saldo).");
            entrada = IN.nextLine();

            if (validarEntrada(entrada, "0"))
                estudiantes.add(new Estudiante(new TarjetaComida()));

            else if (validarEntrada(entrada, "[0-9]+"))
            {
                estudiantes.add(new Estudiante(new TarjetaComida(Integer.parseInt(entrada))));
                System.out.println("\nSaldo registrado correctamente.");

            } else if (validarEntrada(entrada, ""))
                seguirRegistrandoEstudiantes = false;

            else
                System.out.println("\nNúmero inválido!");

        } while (seguirRegistrandoEstudiantes);

        if (estudiantes.size() > 0)
            mostrarAlumnosRegistrados();

        else
        {
            System.out.println("No hay estudiantes registrados.\n¿Desea registrar alguno? (Sí o no)");
            entrada = IN.nextLine();

            if (validarEntrada(entrada, "Si|si|Sí|sí|SI|SÍ|sÍ|sI|s|S"))
                registrarEstudiantes();

        }

    }

    public void mostrarAlumnosRegistrados()
    {

        System.out.println("\n\n\tAlumnos registrados:\n");
        System.out.println(String.format("%-20s%s", "Estudiante", "Saldo en su tarjeta"));

        for (int i = 0; i < estudiantes.size(); i++)
            System.out.printf("%-20d$%d\n", i + 1, estudiantes.get(i).getTarjetaComida().getSaldoTarjeta());

        new Cafeteria(estudiantes).venderAlimentos();

    }

    public ArrayList<Estudiante> getEstudiantes()
    {
        return estudiantes;
    }

    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
