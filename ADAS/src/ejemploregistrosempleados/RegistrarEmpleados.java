package ejemploregistrosempleados;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class RegistrarEmpleados
{

    private Scanner in;
    private ArrayList<Empleado> misEmpleados;

    public RegistrarEmpleados()
    {
        in = new Scanner(System.in);
        misEmpleados = new ArrayList<>();

    }

    public void registrarEmpleados()
    {
        String terminar = "1";

        do
        {
            System.out.println("\nIngrese la clave del empleado: ");
            String clave = in.nextLine();

            System.out.println("\nIngrese el nombre del empleado: ");
            String nombre = in.nextLine();

            System.out.println("\nIngrese el apellido paterno del empleado: ");
            String apellidoPaterno = in.nextLine();

            System.out.println("\nIngrese el apellido materno del empleado: ");
            String apellidoMaterno = in.nextLine();

            Calendar fechaNacimiento = pedirFecha("Fecha de nacimiento");

            Calendar fechaIngreso = pedirFecha("Fecha de ingreso");

            String departamento = pedirDepartamento();

            misEmpleados.add(new Empleado(clave, nombre, apellidoPaterno, apellidoMaterno, departamento, "", fechaNacimiento, fechaIngreso));

            break;

        } while (!terminar.equals("0"));

        misEmpleados.stream().forEach(System.out::println);

    }

    public Calendar pedirFecha(String text)
    {
        GregorianCalendar fecha = new GregorianCalendar(0, 0, 0);
        int dia = 0, mes = 0, anio = 0;
        boolean datosValidos;

        System.out.println("\n---------" + text + "---------");

        do
        {
            datosValidos = true;

            try
            {
                System.out.println("\nInserte el día: ");
                dia = in.nextInt();

                if (!validarEntrada(dia + "", "^[0-3]?[0-9]$"))
                    throw new InputMismatchException();

                System.out.println("\nInserte el mes: ");
                mes = in.nextInt();

                if (!validarEntrada(mes + "", "^[0-1]?[0-9]$"))
                    throw new InputMismatchException();

                System.out.println("\nInserte el año: ");
                anio = in.nextInt();

                if (!validarEntrada(anio + "", "^[1-2][0-9][0-9][0-9]$"))
                    throw new InputMismatchException();

            } catch (InputMismatchException e)
            {
                System.out.println("\nDato inválido, vuelve a insertar la fecha.");

                in.nextLine();
                datosValidos = false;

            }

            if (datosValidos)
                fecha = new GregorianCalendar(anio, mes - 1, dia);

        } while (!isFechaValida(fecha) || !datosValidos);

        in.nextLine();

        return fecha;
    }

    public String pedirDepartamento()
    {
        String departamento = "";
        boolean valido;

        do
        {

            System.out.println("\nDepartamento: ");
            departamento = in.nextLine();

            valido = validarEntrada(departamento, "CO|AL|FI|RH");

            if (!valido)
                System.out.println("\nEntrada no válida, inténtelo de nuevo.");

        } while (!valido);

        return departamento;
    }

    public boolean isFechaValida(GregorianCalendar fecha)
    {
        int dia = fecha.get(Calendar.DAY_OF_MONTH), mes = fecha.get(Calendar.MONTH), anio = fecha.get(Calendar.YEAR);
        int diasMaxFebrero = fecha.isLeapYear(fecha.get(Calendar.YEAR)) ? 29 : 28;

        if (anio <= 1900 || anio > Calendar.getInstance().get(Calendar.YEAR))
            return false;

        if (mes > 11 || mes < 0)
            return false;

        if (dia < 0)
            return false;

        if (mes == 1 && dia > diasMaxFebrero)
            return false;

        switch (mes)
        {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:

                if (dia > 31)
                    return false;

                break;

            case 3:
            case 5:
            case 8:
            case 10:

                if (dia > 30)
                    return false;

                break;

        }

        return true;

    }

    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

    public static void main(String[] args)
    {
        new RegistrarEmpleados().registrarEmpleados();
    }

}
