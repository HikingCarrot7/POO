package ada1_2;

/**
 *
 * @author HikingCarrot7
 */
public class Fecha
{

    private final int dia, mes, anio;
    private final String[] meses =
    {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    public Fecha(int dia, int mes, int anio)
    {
        this.dia = dia;
        this.mes = mes <= 12 && mes >= 1 ? mes : 1;
        this.anio = anio;

    }

    public Fecha()
    {
        this(1, 1, 1900);
    }

    public String mostrarFecha()
    {
        return String.format("%d de %s de %d", dia, meses[mes - 1].toLowerCase(), anio);
    }

}
