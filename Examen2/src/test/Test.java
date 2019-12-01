package test;

import dominio.EmpleadoAdministrador;
import dominio.EmpleadoOperacional;
import dominio.EmpleoTiempoCompleto;
import dominio.EmpleoTiempoParcial;
import dominio.Nomina;
import java.util.Calendar;

/**
 *
 * @author A15001169
 */
public class Test
{

    public void gestionNomina(Nomina nomina)
    {

        nomina.registrarEmpleado(new EmpleadoAdministrador(2372, "Nicolás Canul", Calendar.getInstance(), new EmpleoTiempoParcial(30, 100)));

        nomina.registrarEmpleado(new EmpleadoOperacional(874854, "Javier Chim", Calendar.getInstance(), new EmpleoTiempoParcial(50, 150)));

        nomina.registrarEmpleado(new EmpleadoAdministrador(736473, "Mario Chim", Calendar.getInstance(), new EmpleoTiempoCompleto()));

        nomina.registrarEmpleado(new EmpleadoOperacional(73434, "Eusebio Ajas", Calendar.getInstance(), new EmpleoTiempoCompleto()));

    }

    public static void main(String[] args)
    {

        Test test = new Test();
        Nomina nomina = new Nomina();

        test.gestionNomina(nomina);
        nomina.imprimirReporte(nomina);

        System.out.println("\n\n------Salario cambiado------\n\n");

        EmpleoTiempoCompleto.setSalario(1000);

        nomina.imprimirReporte(nomina);

    }

}
