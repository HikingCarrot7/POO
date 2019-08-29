package ferreteria;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class PruebaFerreteria
{

    private final Empleado[] misEmpleados;
    private final Random rand;
    private final File file;
    private final Scanner in;

    public PruebaFerreteria() throws IOException
    {
        misEmpleados = new Empleado[5];
        rand = new Random();
        in = new Scanner(System.in);

        file = new File("res/Facturas.txt");

        if (!file.exists())
        {
            file.createNewFile();
        }

        misEmpleados[0] = new Empleado("Nicolás", "Canul", "Ibarra", new GregorianCalendar(2000, 0, 6));
        misEmpleados[1] = new Empleado("Eusebio", "Ajas", "Santos", new GregorianCalendar(1999, 5, 25));
        misEmpleados[2] = new Empleado("Carlos", "Álvarez", "Trejo", new GregorianCalendar(1998, 9, 14));
        misEmpleados[3] = new Empleado("Emmanuel", "Chable", "Collí", new GregorianCalendar(2001, 11, 30));
        misEmpleados[4] = new Empleado("Guillermo", "Canto", "Dzul", new GregorianCalendar(2000, 3, 2));

    }

    public void pedirDatos() throws IOException
    {
        while (true)
        {
            System.out.println("Número del producto: ");
            int nProducto = in.nextInt();

            System.out.println("Número de piezas: ");
            int numPiezas = in.nextInt();

            System.out.println("Precio del producto: ");
            float precio = in.nextFloat();

            in.nextLine();

            System.out.println("Nombre del producto:");
            String nombre = in.nextLine();

            generarFactura(new Factura(nProducto, numPiezas, precio, nombre, Calendar.getInstance(), misEmpleados[rand.nextInt(5)]));

        }

    }

    public void generarFactura(Factura factura) throws IOException
    {
        System.out.println(factura);

        try (Formatter out = new Formatter(new FileWriter(file, true)))
        {
            out.format("%s", factura);

        }

    }

    public static void main(String[] args)
    {
        try
        {
            new PruebaFerreteria().pedirDatos();

        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
