package ejer1_11;

import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class Cafeteria
{

    private final Scanner IN;
    private Registro registro;
    private int indexEstudianteActual;

    public Cafeteria(Registro registro)
    {
        this.registro = registro;

        IN = new Scanner(System.in);
    }

    public void despacharAlumno()
    {
        String entrada;
        boolean entradaValida;

        do
        {
            entradaValida = false;

            System.out.println("\nRealizar compras para el estudiante: ");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, "^[1-" + registro.getEstudiantes().size() + "]$"))
            {
                imprimirListaAlimentos();
                indexEstudianteActual = Integer.parseInt(entrada);
                entradaValida = true;

            } else
                System.out.println("\nEntrada inválida.");

        } while (!entradaValida);

        realizarCompra();

    }

    public void realizarCompra()
    {
        boolean seguirComprando;
        String entrada;
        Estudiante estudianteActual = registro.getEstudiantes().get(indexEstudianteActual - 1);

        do
        {
            seguirComprando = false;

            System.out.printf("\nTu saldo actual es: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta());
            System.out.println("\nInserte el alimento que desea comprar (1 - " + Comida.values().length + "), presione \"enter\" para cancelar");
            entrada = IN.nextLine();

            if (registro.validarEntrada(entrada, ""))
                break;

            if (registro.validarEntrada(entrada, "^[1-9]+$")
                    && Integer.parseInt(entrada) <= 15
                    && Comida.values()[Integer.parseInt(entrada) - 1].getPrecio() <= estudianteActual.getTarjetaComida().getSaldoTarjeta())
            {
                Comida comida = Comida.values()[Integer.parseInt(entrada) - 1];

                System.out.printf("\nHa comprado: %s ($%d)", comida, comida.getPrecio());
                estudianteActual.getTarjetaComida().setSaldoTarjeta(estudianteActual.getTarjetaComida().getSaldoTarjeta() - comida.getPrecio());

                System.out.println("\n¿Deseas realizar otra compra? (Sí o No)");
                entrada = IN.nextLine();

                if (registro.validarEntrada(entrada, "Si|si|Sí|sí|SI|SÍ|sÍ|sI|s|S"))
                    seguirComprando = true;
                else
                    System.out.printf("\nTe quedaste con un saldo de: $%d", estudianteActual.getTarjetaComida().getSaldoTarjeta());

            } else
            {
                System.out.println("\nCantidad inválida o no tienes saldo suficiente.");
                seguirComprando = true;
            }

        } while (seguirComprando);

        System.out.println("\n¿Habrá otra compra?");
        entrada = IN.nextLine();

        if (registro.validarEntrada(entrada, "Si|si|Sí|sí|SI|SÍ|sÍ|sI|s|S"))
        {
            registro.mostrarEstudiantesRegistrados();
            despacharAlumno();

        }

    }

    public void imprimirListaAlimentos()
    {
        System.out.printf("\n%-20s%s\n", "<<Alimento>>", "<<Precio>>");

        for (int i = 0; i < Comida.values().length; i++)
            System.out.printf("%02d.- %-15s$%d\n", i + 1, Comida.values()[i], Comida.values()[i].getPrecio());

    }

}
