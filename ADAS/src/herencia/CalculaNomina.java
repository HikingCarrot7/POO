package herencia;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juan.ucan
 */
public class CalculaNomina
{

    public static void main(String[] args)
    {
        Scanner entradaStr = new Scanner(System.in);
        Scanner entradaDob = new Scanner(System.in);
        Scanner entradaInt = new Scanner(System.in);

        ArrayList<EmpleadoPorComision> lista = new ArrayList();
        boolean continuar = true;
        String nombre, apellidoP, apellidoM, segSocial;
        double ventasBrutas, tarifaComision;

        do
        {
            System.out.println("Qué tipo de empleado desea capturar: "
                    + "\n 1: Empleado por comisión "
                    + "\n 2: Empleado base más comisión "
                    + "\n Escriba una opción:");
            int opcion = entradaInt.nextInt();

            switch (opcion)
            {
                case 1:
                {
                    System.out.println("********** Datos de un empleado por comisión **********");

                    System.out.println("Escriba el nombre: ");
                    nombre = entradaStr.nextLine();

                    System.out.println("Escriba el apellido paterno: ");
                    apellidoP = entradaStr.nextLine();

                    System.out.println("Escriba el apellido materno: ");
                    apellidoM = entradaStr.nextLine();

                    System.out.println("Escriba el número de seguro social: ");
                    segSocial = entradaStr.nextLine();

                    System.out.println("Escriba el total de las ventas brutas: ");
                    ventasBrutas = entradaDob.nextDouble();

                    System.out.println("Escriba la tarifa comisión: ");
                    tarifaComision = entradaDob.nextDouble();

                    EmpleadoPorComision unEmpleado = new EmpleadoPorComision(nombre, apellidoP, apellidoM, segSocial, ventasBrutas, tarifaComision);
                    lista.add(unEmpleado);
                    //System.out.println(unEmpleado);
                    //System.out.println("sueldo: " + unEmpleado.ingreso());

                    break;
                }
                case 2:
                {
                    System.out.println("********** Datos de un empleado base más comisión **********");

                    System.out.println("Escriba el nombre: ");
                    nombre = entradaStr.nextLine();

                    System.out.println("Escriba el apellido paterno: ");
                    apellidoP = entradaStr.nextLine();

                    System.out.println("Escriba el apellido materno: ");
                    apellidoM = entradaStr.nextLine();

                    System.out.println("Escriba el número de seguro social: ");
                    segSocial = entradaStr.nextLine();

                    System.out.println("Escriba el total de las ventas brutas: ");
                    ventasBrutas = entradaDob.nextDouble();

                    System.out.println("Escriba la tarifa comisión: ");
                    tarifaComision = entradaDob.nextDouble();

                    System.out.println("Escriba el sueldo base: ");
                    double sueldoBase = entradaDob.nextDouble();

                    EmpleadoBaseMasComision2 unEmpleado2 = new EmpleadoBaseMasComision2(nombre, apellidoP, apellidoM, segSocial, ventasBrutas, tarifaComision, sueldoBase);
                    lista.add(unEmpleado2);
                    //System.out.println(unEmplado2);
                    //System.out.println("sueldo: " + unEmpleado2.ingreso());
                    break;

                }
                default:
                    System.out.println("La opción capturada no es válida");

            }

            System.out.println("Desea capturar más empleados: S: si, N: no");
            String opcionCaptura = entradaStr.nextLine();

            if (opcionCaptura.equals("N"))
                continuar = false;

        } while (continuar);

        for (EmpleadoPorComision empleado : lista)
        {
            System.out.println(empleado);
            System.out.println(empleado.ingreso());

        }

    }

}
