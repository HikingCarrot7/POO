package dominio;

/**
 *
 * @author HikingCarrot7
 */
public class Count
{

    //Crear un estudiante graduado, (datos). estudiante no graduado (datos). imprimir el toString paquete test, estudiantes, asignatura
    private int serialNumber;
    private static int counter;

    public Count()
    {
        serialNumber = counter++;
    }

    public int getSerialNumber()
    {
        return serialNumber;
    }

    public static int getCounter()
    {
        return counter;
    }

}
