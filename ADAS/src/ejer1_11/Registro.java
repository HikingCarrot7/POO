package ejer1_11;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.String.format;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class Registro
{

    private final Scanner IN;
    private ArrayList<Estudiante> estudiantes; // Estudiantes registrados.

    /**
     * Inicializa nuestros atributos de clase.
     */
    public Registro()
    {
        estudiantes = new ArrayList<>();
        IN = new Scanner(in);

    }

    /**
     * Proceso para registrar a los estudiantes.
     */
    public void registrarEstudiantes()
    {

        boolean seguirRegistrandoEstudiantes;
        String entrada; // Entrada de datos.

        do
        {
            seguirRegistrandoEstudiantes = true;

            out.println("\nInserte el saldo de la tarjeta de comida para este estudiante."
                    + "\n(presione \"enter\" para cancelar o \"0\" si no desea insertarle saldo).");
            entrada = IN.nextLine();

            if (validarEntrada(entrada, "0")) // Si se presionar "0" se añade $100 como cantidad por defecto a la tarjeta de este estudiante.
                estudiantes.add(new Estudiante(new TarjetaComida()));

            else if (validarEntrada(entrada, "[0-9]+")) // Se valida la entrada.
            {
                estudiantes.add(new Estudiante(new TarjetaComida(parseInt(entrada))));
                out.println("\nSaldo registrado correctamente.");

            } else if (validarEntrada(entrada, "")) // Si se presiona "enter" la operación termina.
                seguirRegistrandoEstudiantes = false;

            else
                out.println("\nNúmero inválido.");

        } while (seguirRegistrandoEstudiantes);

        accionesSobreEstudiantesRegistrados(); // Acciones sobre los estudiantes registrados.

    }

    /**
     * Acciones disponibles para los estudiantes registrados.
     */
    public void accionesSobreEstudiantesRegistrados()
    {
        String entrada;

        if (estudiantes.size() > 0) // Verificamos que existan estudiantes registrados.
        {
            mostrarEstudiantesRegistrados(); // Se muestra a los estudiantes registrados.

            do
            {

                out.println("\nPresione \"1\" para despachar a los estudiantes"
                        + "\nPresione \"2\" para cambiar el saldo de la tarjeta de algún estudiante"
                        + "\nPresione \"3\" para añadir a más estudiantes"); // Opciones disponibles.
                entrada = IN.nextLine();

                if (validarEntrada(entrada, "1"))
                    new Cafeteria(this).despacharAlumno();

                else if (validarEntrada(entrada, "2"))
                    actualizarTarjetaEstudiante();

                else if (validarEntrada(entrada, "3"))
                    registrarEstudiantes();

                else
                    out.println("\nOpción inválida");

            } while (true);

        } else if (confirmacion("\nNo hay estudiantes registrados.\n\n¿Desea registrar alguno? (Sí o No)"))
            registrarEstudiantes();
        else
            out.println("\nBUILD STOPPED.\n"); // El proceso termina.

    }

    /**
     * Actualización de la tarjata de comida para un estudiante.
     */
    public void actualizarTarjetaEstudiante()
    {
        String entrada;
        String indexEstudiante;
        boolean continuar;

        do
        {

            out.println("\n¿A cuál estudiante desea añadirle puntos a su tarjeta de comida? (1 - " + estudiantes.size() + ")");
            indexEstudiante = IN.nextLine();

            if (validarEntrada(indexEstudiante, "^[1-" + estudiantes.size() + "]$")) // Se valida que la entrada este dentro del rango.
            {
                boolean cantidadInvalida;

                do
                {
                    cantidadInvalida = true;

                    out.printf("\nInserte los puntos a añadir para el estudiante %s:", indexEstudiante);
                    entrada = IN.nextLine();

                    if (validarEntrada(entrada, "^-?[0-9]+$")) // Se valida cantidad a añadir.
                    {
                        Estudiante estudiante = estudiantes.get(parseInt(indexEstudiante) - 1);
                        estudiante.getTarjetaComida().setSaldoTarjeta(estudiante.getTarjetaComida().getSaldoTarjeta() + parseInt(entrada)); // Se actualiza el saldo del estudiante.

                        out.println("\nSaldo actualizado correctamente");

                        cantidadInvalida = false;

                    } else
                        out.println("\nCantidad inválida");

                } while (cantidadInvalida);

                continuar = confirmacion("\n¿Actualizar tarjeta a otro alumno? (Si o No)"); // Preguntamos si se desea volver a actualizar la tarjeta de algún estudiante.

            } else
            {
                out.println("\nCantidad inválida");

                continuar = true;
            }

        } while (continuar);

        accionesSobreEstudiantesRegistrados(); // Volvemos a mostrar las opciones sobre los estudiantes registrados.

    }

    /**
     * Mostramos a los estudiantes registrados.
     */
    public void mostrarEstudiantesRegistrados()
    {

        out.println("\n\n\tAlumnos registrados:\n");
        out.println(format("%-20s%s", "Estudiante", "Saldo en su tarjeta"));

        for (int i = 0; i < estudiantes.size(); i++)
            out.printf("%-20d$%d\n", i + 1, estudiantes.get(i).getTarjetaComida().getSaldoTarjeta());

    }

    /**
     * Retorna a los estudiantes registrados.
     *
     * @return La lista de los estudiantes registrados.
     */
    public ArrayList<Estudiante> getEstudiantes()
    {
        return estudiantes;
    }

    /**
     * Pregunta de confirmación para proceder.
     *
     * @param text La pregunta a mostrar.
     *
     * @return <code>true</code> si el usuario afirma o <code>false</code> en caso contrario.
     */
    public boolean confirmacion(String text)
    {
        String entrada;

        out.println(text);
        entrada = IN.nextLine();

        return validarEntrada(entrada, "Si|si|Sí|sí|SI|SÍ|sÍ|sI|s|S");

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
