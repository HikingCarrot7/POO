package dominio;

import static java.lang.String.format;
import static java.lang.System.out;
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
        double total = 0;

        for (int i = 0; i < empleados.size(); i++)
            if (empleados.get(i).getEmpleo() instanceof EmpleoTiempoParcial)
                total += empleados.get(i).getEmpleo().getSalario();

        return total;
    }

    public double totalSueldoEmpleadosTiempoCompleto()
    {
        double total = 0;

        for (int i = 0; i < empleados.size(); i++)
            if (empleados.get(i).getEmpleo() instanceof EmpleoTiempoCompleto)
                total += empleados.get(i).getEmpleo().getSalario();

        return total;
    }

    public void imprimirReporte(Nomina nomina)
    {
        out.println("Empleados TC");
        out.printf("%-10s%-30s%-25s%-30s%s\n", "Clave", "Nombre", "Fecha ingreso", "Administrador/Operador", "Sueldo semanal");

        for (int i = 0; i < nomina.getEmpleados().size(); i++)
            if (nomina.getEmpleado(i).getEmpleo() instanceof EmpleoTiempoCompleto)
            {
                Empleado empleado = nomina.getEmpleado(i);

                out.printf(format("%-10d%-30s%-25s%-30s$%,.2f\n",
                        empleado.getClave(),
                        empleado.getNombre(),
                        format("%td-%1$tm-%1$ty", empleado.getFecha()),
                        empleado instanceof EmpleadoAdministrador ? "Administrador" : "Operacional",
                        empleado.getEmpleo().getSalario()));

            }

        out.println("Total : $" + nomina.totalSueldoEmpleadosTiempoCompleto());

        out.println("\n\nEmpleados TP");
        out.printf("%-10s%-30s%-25s%-30s%s\n", "Clave", "Nombre", "Fecha ingreso", "Administrador/Operador", "Sueldo semanal");

        for (int i = 0; i < nomina.getEmpleados().size(); i++)
            if (nomina.getEmpleado(i).getEmpleo() instanceof EmpleoTiempoParcial)
            {
                Empleado empleado = nomina.getEmpleado(i);

                out.printf(format("%-10d%-30s%-25s%-30s$%,.2f\n",
                        empleado.getClave(),
                        empleado.getNombre(),
                        format("%td-%1$tm-%1$ty", empleado.getFecha()),
                        empleado instanceof EmpleadoAdministrador ? "Administrador" : "Operacional",
                        empleado.getEmpleo().getSalario()));

            }

        out.println("Total : $" + nomina.totalSueldoEmpleadosTiempoParcial());
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
