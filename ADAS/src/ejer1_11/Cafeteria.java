package ejer1_11;

import static ejer1_11.Comida.values;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Scanner;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class Cafeteria
{

    private final Scanner IN;
    private Registro registro;
    private int indexEstudianteActual;

    /**
     * Inicializa nuestros atributos de clase.
     *
     * @param registro Objeto Registro para acceder a algunos métodos de esa clase.
     */
    public Cafeteria(Registro registro)
    {
        this.registro = registro;

        IN = new Scanner(in);
    }

    /**
     * Seleccionar al estudiante al cual se le atenderá para hacer su compra.
     */
    public void despacharAlumno()
    {
        String entrada; // Entrada de datos.
        boolean entradaValida;

        do
        {
            entradaValida = false;

            out.println("\nRealizar compras para el estudiante (1 - " + registro.getEstudiantes().size() + ")");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, "^[1-" + registro.getEstudiantes().size() + "]$")) // Se valida que la entrada este entre el rango de estudiantes registrados.
            {
                imprimirListaAlimentos(); // Se imprime la lista de alimentos.
                indexEstudianteActual = parseInt(entrada);
                entradaValida = true;

            } else
                out.println("\nEntrada inválida.");

        } while (!entradaValida);

        realizarCompra(); // Se atiende al estudiante seleccionado.

    }

    /**
     * Atender al estudiante seleccionado.
     */
    public void realizarCompra()
    {
        boolean seguirComprando;
        String entrada; // Entrada de datos.
        Estudiante estudianteActual = registro.getEstudiantes().get(indexEstudianteActual - 1); // Estudiante seleccionado actualmente.

        do
        {
            seguirComprando = false;

            out.printf("\nTu saldo actual es: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta()); // Saldo del estudiante actual.
            out.println("\nInserte el alimento que desea comprar (1 - " + values().length + "), presione \"enter\" para cancelar");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, "")) // Si se presiona "enter" la operación se cancela.
                break;

            if (registro.validarEntrada(entrada, "^[1-9]+$")
                    && parseInt(entrada) <= values().length // Validamos que la entrada sea válida y que el estudiante tenga los suficientes puntos para hacer la compra.
                    && values()[parseInt(entrada) - 1].getPrecio() <= estudianteActual.getTarjetaComida().getSaldoTarjeta())
            {
                Comida comida = values()[parseInt(entrada) - 1];

                out.printf("\nHa comprado: %s ($%d)", comida, comida.getPrecio()); // Comida que compró
                estudianteActual.getTarjetaComida().setSaldoTarjeta(estudianteActual.getTarjetaComida().getSaldoTarjeta() - comida.getPrecio());

                if (registro.confirmacion("\n¿Deseas realizar otra compra? (Sí o No)"))
                    seguirComprando = true;
                else
                    out.printf("\nTe quedaste con un saldo de: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta()); // Saldo restante.

            } else
            {
                out.println("\nCantidad inválida o no tienes saldo suficiente.");
                seguirComprando = true;
            }

        } while (seguirComprando);

        if (registro.confirmacion("\n¿Habrá otra compra? (Sí o No)"))
        {

            registro.mostrarEstudiantesRegistrados(); // Si se hará otra compra, se muestran los estudiantes registrados.
            despacharAlumno(); // Se selecciona a un nuevo alumno para despachar.

        } else
            registro.accionesSobreEstudiantesRegistrados(); //Mostramos las opciones para los estudiantes registrados.

    }

    /**
     * Impresion de los alimentos disponibles en la cafetera.
     */
    public void imprimirListaAlimentos()
    {
        out.printf("\n%-20s%s\n", "<<Alimento>>", "<<Precio>>");

        for (int i = 0; i < values().length; i++)
            out.printf("%02d.- %-15s$%d\n", i + 1, values()[i], values()[i].getPrecio());

    }

}
