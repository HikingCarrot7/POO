package ejer1_04;

import static java.lang.String.format;

/**
 *
 * @author HikingCarrot7
 */
public class Bicicleta
{

    private static int identificacion = 0;
    private int identificacionBicicleta;
    private String nombre;
    private String telefono;

    public Bicicleta(String nombre, String telefono)
    {
        this.nombre = nombre;
        this.telefono = telefono;
        identificacionBicicleta = ++identificacion;
    }

    public int getIdentificacion()
    {
        return identificacionBicicleta;
    }

    public void setIdentificacion(int identificacionBicicleta)
    {
        this.identificacionBicicleta = identificacionBicicleta;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    @Override
    public String toString()
    {
        return format("\nNombre del propietario: %s\nIdentificación: %s\nTeléfono: %s\n", getNombre(), getIdentificacion(), getTelefono());
    }

}
