package ejemploregistrosempleados;

import java.util.Calendar;

/**
 *
 * @author Mahammed
 */
public final class Empleado
{

    private String clave, nombre, apellidoPaterno, apellidoMaterno, departamento;
    private Horario horarioTrabajo;
    private Calendar fechaNacimiento, fechaIngreso;

    public Empleado(String clave, String nombre, String apellidoPaterno, String apellidoMaterno, String departamento, Horario horarioTrabajo, Calendar fechaNacimiento, Calendar fechaIngreso)
    {
        this.clave = clave;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.departamento = departamento;
        this.horarioTrabajo = horarioTrabajo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getClave()
    {
        return clave;
    }

    public void setClave(String clave)
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

    public String getDepartamento()
    {
        return departamento;
    }

    public void setDepartamento(String departamento)
    {
        this.departamento = departamento;
    }

    public Horario getHorarioTrabajo()
    {
        return horarioTrabajo;
    }

    public void setHorarioTrabajo(Horario horarioTrabajo)
    {
        this.horarioTrabajo = horarioTrabajo;
    }

    public Calendar getFechaNacimiento()
    {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento)
    {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Calendar getFechaIngreso()
    {
        return fechaIngreso;
    }

    public void setFechaIngreso(Calendar fechaIngreso)
    {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString()
    {
        String lineSeparator = System.getProperty("line.separator");

        return String.format("%7$sClave: %s%7$sNombre: %s%7$sDepartamento: %s%7$sHorario de trabajo: %s%7$sFecha de nacimiento: %s%7$sFecha de ingreso: %s%7$s%7$s",
                getClave(),
                String.format("%s %s %s", getNombre(), getApellidoPaterno(), getApellidoMaterno()),
                getDepartamento(),
                getHorarioTrabajo(),
                String.format("%1$tA, %1$tB %1$td, %1$tY", getFechaNacimiento()),
                String.format("%1$tA, %1$tB %1$td, %1$tY", getFechaIngreso()),
                lineSeparator);
    }

}
