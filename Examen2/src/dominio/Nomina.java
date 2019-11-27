package dominio;

import java.util.ArrayList;

/**
 *
 * @author A15001169
 */
public class Nomina
{

    private ArrayList<Empleado> empleados;

    public Nomina()
    {
        empleados = new ArrayList<>();
    }

    public void registrarEmpleado(Empleado empleado)
    {
        empleados.add(empleado);
    }

    public void eliminarEmpleado(Empleado empleado)
    {
        empleados.remove(empleado);
    }

    public double totalSueldoEmpleadosTiempoParcial()
    {
        double j = 0;

        for (int i = 0; i < empleados.size(); i++)
            if (empleados.get(i).getEmpleo() instanceof EmpleoTiempoParcial)
                j += empleados.get(i).getEmpleo().getSalario();

        return j;

    }

    public double totalSueldoEmpleadosTiempoCompleto()
    {
        double j = 0;

        for (int i = 0; i < empleados.size(); i++)
            if (empleados.get(i).getEmpleo() instanceof EmpleoTiempoCompleto)
                j += empleados.get(i).getEmpleo().getSalario();

        return j;

    }

    public void imprimirReporte(Nomina nomina)
    {

        System.out.println("Empleados TC");
        System.out.printf("%-10s%-30s%-25s%-30s%s\n", "Clave", "Nombre", "Fecha ingreso", "Administrador/Operador", "Sueldo semanal");

        for (int i = 0; i < nomina.getEmpleados().size(); i++)
            if (nomina.getEmpleado(i).getEmpleo() instanceof EmpleoTiempoCompleto)
            {

                Empleado empleado = nomina.getEmpleado(i);

                System.out.printf(String.format("%-10d%-30s%-25s%-30s$%,.2f\n",
                        empleado.getClave(),
                        empleado.getNombre(),
                        String.format("%td-%1$tm-%1$ty", empleado.getFecha()),
                        empleado instanceof EmpleadoAdministrador ? "Administrador" : "Operacional",
                        empleado.getEmpleo().getSalario()));

            }

        System.out.println("Total : $" + nomina.totalSueldoEmpleadosTiempoCompleto());

        System.out.println("\n\nEmpleados TP");
        System.out.printf("%-10s%-30s%-25s%-30s%s\n", "Clave", "Nombre", "Fecha ingreso", "Administrador/Operador", "Sueldo semanal");

        for (int i = 0; i < nomina.getEmpleados().size(); i++)
            if (nomina.getEmpleado(i).getEmpleo() instanceof EmpleoTiempoParcial)
            {

                Empleado empleado = nomina.getEmpleado(i);

                System.out.printf(String.format("%-10d%-30s%-25s%-30s$%,.2f\n",
                        empleado.getClave(),
                        empleado.getNombre(),
                        String.format("%td-%1$tm-%1$ty", empleado.getFecha()),
                        empleado instanceof EmpleadoAdministrador ? "Administrador" : "Operacional",
                        empleado.getEmpleo().getSalario()));

            }

        System.out.println("Total : $" + nomina.totalSueldoEmpleadosTiempoParcial());

    }

    public Empleado getEmpleado(int index)
    {
        return empleados.get(index);
    }

    public ArrayList<Empleado> getEmpleados()
    {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados)
    {
        this.empleados = empleados;
    }

}
