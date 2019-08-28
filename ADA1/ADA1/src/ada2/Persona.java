package ada2;

/**
 *
 * @author HikingCarrot7
 */
public class Persona
{

    private String nombre;
    private final String regex;
    private int edad;

    public Persona(String nombre, int edad, String regex)
    {
        this.nombre = nombre;
        this.edad = edad;
        this.regex = regex;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        if (validarFormatoNombre(nombre))
        {
            this.nombre = nombre;
        }
    }

    public int getEdad()
    {
        return edad;
    }

    public void setEdad(int edad)
    {
        this.edad = edad;
    }

    @Override
    public String toString()
    {
        return String.format("%-25s%s", "Mi nombre es: " + getNombre(), "Mi edad es: " + getEdad());
    }

    public boolean validarFormatoNombre(String nombre)
    {
        return nombre.matches(regex);
    }

}
