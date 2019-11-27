package dominio;

/**
 *
 * @author A15001169
 */
public class EmpleoTiempoCompleto extends Empleo
{

    private static double salario = 500;

    @Override
    public double getSalario()
    {
        return salario;
    }

    public static void setSalario(double salario)
    {
        EmpleoTiempoCompleto.salario = salario;
    }

}
