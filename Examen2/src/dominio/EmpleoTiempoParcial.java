package dominio;

/**
 *
 * @author A15001169
 */
public class EmpleoTiempoParcial extends Empleo
{

    private int horasTrabajadasSemana;
    private double salarioHoraTrabajo;

    public EmpleoTiempoParcial(int horasTrabajadasSemana, double salarioHoraTrabajo)
    {
        this.horasTrabajadasSemana = horasTrabajadasSemana;
        this.salarioHoraTrabajo = salarioHoraTrabajo;
    }

    public int getHorasTrabajadasSemana()
    {
        return horasTrabajadasSemana;
    }

    public void setHorasTrabajadasSemana(int horasTrabajadasSemana)
    {
        this.horasTrabajadasSemana = horasTrabajadasSemana;
    }

    public double getSalarioHoraTrabajo()
    {
        return salarioHoraTrabajo;
    }

    public void setSalarioHoraTrabajo(double salarioHoraTrabajo)
    {
        this.salarioHoraTrabajo = salarioHoraTrabajo;
    }

    @Override
    public double getSalario()
    {
        return salarioHoraTrabajo * horasTrabajadasSemana;
    }

}
