package ejemplosEnum;

/**
 *
 * @author HikingCarrot7
 */
public class PruebaCompanero
{

    private PruebaCompanero c;
    private final String id;

    public PruebaCompanero(String id, PruebaCompanero c)
    {
        this.id = id;
        this.c = c;
    }

    public PruebaCompanero(String id)
    {
        this(id, null);
    }

    public void clonar(PruebaCompanero c)
    {
        try
        {
            this.c = (PruebaCompanero) c.clone();

        } catch (CloneNotSupportedException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public PruebaCompanero getPruebaCompanero()
    {
        return c;
    }

    public String getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return c.getId();
    }

    public static void main(String[] args)
    {

        PruebaCompanero c = new PruebaCompanero("1");

        PruebaCompanero c1 = new PruebaCompanero("2", c);

        c1.clonar(new PruebaCompanero("3", c));

        System.out.println(c1);

        for (Companero companero : Companero.values())
        {
            if (validarNombre(companero.getNombre()))
            {
                System.out.println(Enum.valueOf(Companero.class, companero.getNombre()));
            }

        }
        
        System.out.println(new B().obtenerLongitud("Nicolás"));

    }

    public static boolean validarNombre(String nombre)
    {
        return nombre.matches("^C[a-zA-Z]*s$");
    }
}

class A<T extends String>
{

    public int obtenerLongitud(String t)
    {
        return t.length();
    }

    public String obtenerString(A<? extends String> string)
    {
        return string.toString();
    }

}

class B extends A
{

    @Override
    public int obtenerLongitud(String t)
    {
        return t.length();
    }

}
