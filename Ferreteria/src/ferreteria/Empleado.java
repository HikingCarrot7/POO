package ferreteria;

import java.util.Calendar;

/**
 *
 * @author Mohammed
 */
public class Empleado
{

    private String nombre, apellidoPaterno, apellidoMaterno;
    private Calendar fechaDeNacimiento;

    public Empleado(String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaDeNacimiento)
    {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaDeNacimiento()
    {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Calendar fechaDeNacimiento)
    {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %s", getNombre(), getApellidoPaterno(), getApellidoMaterno());
    }

}
