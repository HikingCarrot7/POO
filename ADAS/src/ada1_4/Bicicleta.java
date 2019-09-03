package ada1_4;

/**
 *
 * @author HikingCarrot7
 */
public class Bicicleta
{

    private String identificacion;
    private String nombre;
    private int telefono;

    public Bicicleta(String identificacion, String nombre, int telefono)
    {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getIdentificacion()
    {
        return identificacion;
    }

    public void setIdentificacion(String identificacion)
    {
        this.identificacion = identificacion;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getTelefono()
    {
        return telefono;
    }

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public String mostrarDatos()
    {
        return String.format("Nombre del propietario: %s\nIdentificación: %s Teléfono: %d", getNombre(), getIdentificacion(), getTelefono());
    }

}
