package ejemplosEnum;

/**
 *
 * @author HikingCarrot7
 */
public enum Companero
{
    Nicolas("Nicolas", 19),
    Carlos("Carlos", 26);
    
    private final String nombre;
    private final int edad;
    
    private Companero(String nombre, int edad)
    {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre()
    {
        return nombre;
    }

    public int getEdad()
    {
        return edad;
    }
    
    @Override
    public String toString()
    {
        return String.format("%-25s%s", "Mi nombre es: " + getNombre(), "Mi edad es: " + getEdad());
    }
}
