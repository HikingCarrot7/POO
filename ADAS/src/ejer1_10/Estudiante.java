package ejer1_10;

/**
 *
 * @author Mohammed
 */
public abstract class Estudiante
{

    protected final static int NUM_DE_EXAMENES = 3;
    protected int[] examen;
    protected int edad;
    protected int sexo;
    protected String nombre;
    protected String calificacionCurso;

    public Estudiante(String nombre)
    {
        this.nombre = nombre;
        examen = new int[NUM_DE_EXAMENES];
        edad = 25;
    }

    public String obtenCalificacionCurso()
    {
        return calificacionCurso;
    }

    public String obtenNombre()
    {
        return nombre;
    }

    public int obtenCalifExamen(int numExamen)
    {
        return examen[numExamen - 1];
    }

    public void asignaNombre(String nuevoNombre)
    {
        nombre = nuevoNombre;
    }

    public void asignaCalifExamen(int numExamen, int califExamen)
    {
        examen[numExamen - 1] = califExamen;
    }

    public abstract void calculaCalificacionCurso();

}
