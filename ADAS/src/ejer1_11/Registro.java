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
                System.out.println("\nNúmero inválido.");

        } while (seguirRegistrandoEstudiantes);

        accionesSobreEstudiantesRegistrados();

    }

    public void accionesSobreEstudiantesRegistrados()
    {
        String entrada;

        if (estudiantes.size() > 0)
        {
            mostrarEstudiantesRegistrados();

            do
            {

                System.out.println("\nPresione \"1\" para despachar a los estudiantes"
                        + "\nPresione \"2\" para cambiar el saldo de la tarjeta de algún estudiante"
                        + "\nPresione \"3\" para añadir a más estudiantes");
                entrada = IN.nextLine();

                if (validarEntrada(entrada, "1"))
                    new Cafeteria(this).despacharAlumno();

                else if (validarEntrada(entrada, "2"))
                    actualizarTarjetaEstudiante();

                else if (validarEntrada(entrada, "3"))
                    registrarEstudiantes();

                else
                    System.out.println("\nOpción inválida");

            } while (true);

        } else if (confirmacion("\nNo hay estudiantes registrados.\n\n¿Desea registrar alguno? (Sí o No)"))
            registrarEstudiantes();
        else
            System.out.println("\nBUILD SUCCESSFUL.\n");

    }

    public void actualizarTarjetaEstudiante()
    {
        String entrada;
        String indexEstudiante;
        boolean continuar;

        do
        {
            continuar = false;

            System.out.println("\n¿A cuál estudiante desea añadirle puntos su tarjeta de comida? (1 - " + estudiantes.size() + ")");
            indexEstudiante = IN.nextLine();

            if (validarEntrada(indexEstudiante, "^[1-" + estudiantes.size() + "]$"))
            {
                boolean cantidadInvalida;

                do
                {
                    cantidadInvalida = true;

                    System.out.printf("\nInserte los puntos a añadir para el estudiante %s:", indexEstudiante);
                    entrada = IN.nextLine();

                    if (validarEntrada(entrada, "^[0-9]+$"))
                    {
                        Estudiante estudiante = estudiantes.get(Integer.parseInt(indexEstudiante) - 1);
                        estudiante.getTarjetaComida().setSaldoTarjeta(estudiante.getTarjetaComida().getSaldoTarjeta() + Integer.parseInt(entrada));

                        System.out.println("\nSaldo actualizado correctamente");

                        cantidadInvalida = false;

                    } else
                        System.out.println("\nCantidad inválida");

                } while (cantidadInvalida);

                continuar = confirmacion("\n¿Actualizar tarjeta a otro alumno? (Si o No)");

            }

        } while (continuar);

        accionesSobreEstudiantesRegistrados();

    }

    public void mostrarEstudiantesRegistrados()
    {

        System.out.println("\n\n\tAlumnos registrados:\n");
        System.out.println(String.format("%-20s%s", "Estudiante", "Saldo en su tarjeta"));

        for (int i = 0; i < estudiantes.size(); i++)
            System.out.printf("%-20d$%d\n", i + 1, estudiantes.get(i).getTarjetaComida().getSaldoTarjeta());

    }

    public ArrayList<Estudiante> getEstudiantes()
    {
        return estudiantes;
    }

    public boolean confirmacion(String text)
    {
        String entrada;

        System.out.println(text);
        entrada = IN.nextLine();

        return validarEntrada(entrada, "Si|si|Sí|sí|SI|SÍ|sÍ|sI|s|S");

    }

    public boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
