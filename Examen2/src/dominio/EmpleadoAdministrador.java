package dominio;

import java.util.Calendar;

/**
 *
 * @author A15001169
 */
public class EmpleadoAdministrador extends Empleado implements Administrativo
{

    public EmpleadoAdministrador(int clave, String nombre, Calendar fecha, Empleo empleo)
    {
        super(clave, nombre, fecha, empleo);
    }

    @Override
    public void planear()
    {

    }

    @Override
    public void organizar()
    {

    }

    @Override
    public void gestionarProyectos()
    {

    }

}
