package dominio;

import java.util.Calendar;

/**
 *
 * @author A15001169
 */
public class EmpleadoOperacional extends Empleado implements Operativo
{

    public EmpleadoOperacional(int clave, String nombre, Calendar fecha, Empleo empleo)
    {
        super(clave, nombre, fecha, empleo);

    }

    @Override
    public void implementar()
    {

    }

    @Override
    public void monitorear()
    {

    }

}
