package ejer1_11;

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

        IN = new Scanner(System.in);
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

            System.out.println("\nRealizar compras para el estudiante (1 - " + registro.getEstudiantes().size() + ")");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, "^[1-" + registro.getEstudiantes().size() + "]$")) // Se valida que la entrada este entre el rango de estudiantes registrados.
            {
                imprimirListaAlimentos();
                indexEstudianteActual = Integer.parseInt(entrada);
                entradaValida = true;

            } else
                System.out.println("\nEntrada inválida.");

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

            System.out.printf("\nTu saldo actual es: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta()); // Saldo del estudiante actual.
            System.out.println("\nInserte el alimento que desea comprar (1 - " + Comida.values().length + "), presione \"enter\" para cancelar");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, "")) // Si se presiona "enter" la operación se cancela.
                break;

            if (registro.validarEntrada(entrada, "^[1-9]+$")
                    && Integer.parseInt(entrada) <= 15 // Validamos que la entrada sea válida y que el estudiante tenga los suficientes puntos para hacer la compra.
                    && Comida.values()[Integer.parseInt(entrada) - 1].getPrecio() <= estudianteActual.getTarjetaComida().getSaldoTarjeta())
            {
                Comida comida = Comida.values()[Integer.parseInt(entrada) - 1];

                System.out.printf("\nHa comprado: %s ($%d)", comida, comida.getPrecio()); // Comida que compró
                estudianteActual.getTarjetaComida().setSaldoTarjeta(estudianteActual.getTarjetaComida().getSaldoTarjeta() - comida.getPrecio());

                if (registro.confirmacion("\n¿Deseas realizar otra compra? (Sí o No)"))
                    seguirComprando = true;
                else
                    System.out.printf("\nTe quedaste con un saldo de: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta()); // Saldo restante.

            } else
            {
                System.out.println("\nCantidad inválida o no tienes saldo suficiente.");
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
        System.out.printf("\n%-20s%s\n", "<<Alimento>>", "<<Precio>>");

        for (int i = 0; i < Comida.values().length; i++)
            System.out.printf("%02d.- %-15s$%d\n", i + 1, Comida.values()[i], Comida.values()[i].getPrecio());

    }

}
