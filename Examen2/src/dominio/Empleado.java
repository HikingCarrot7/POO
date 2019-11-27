package dominio;

import java.util.Calendar;

/**
 *
 * @author A15001169
 */
public abstract class Empleado
{

    private int clave;
    private String nombre;
    private Calendar fecha;
    private Empleo empleo;

    public Empleado(int clave, String nombre, Calendar fecha, Empleo empleo)
    {
        this.clave = clave;
        this.nombre = nombre;
        this.fecha = fecha;
        this.empleo = empleo;

    }

    public int getClave()
    {
        return clave;
    }

    public void setClave(int clave)
    {
        this.clave = clave;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Calendar getFecha()
    {
        return fecha;
    }

    public void setFecha(Calendar fecha)
    {
        this.fecha = fecha;
    }

    public Empleo getEmpleo()
    {
        return empleo;
    }

    public void setEmpleo(Empleo empleo)
    {
        this.empleo = empleo;
    }

}
