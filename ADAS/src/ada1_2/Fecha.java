package ada1_2;

/**
 * Se crean fechas con los parámetros especificados en el constructor.
 *
 * @author Mohammed
 */
public class Fecha
{

    private final int dia, mes, anio;
    private final String[] meses =
    {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };

    /**
     * Crea un objeto fecha con el día, mes y año que especifiquemos.
     *
     * @param dia El día de la fecha.
     * @param mes El mes de la fecha.
     * @param anio El año de la fecha.
     *
     * @since 1.0
     *
     */
    public Fecha(int dia, int mes, int anio)
    {
        this.dia = dia;
        this.mes = mes <= 12 && mes >= 1 ? mes : 1;
        this.anio = anio;

    }

    /**
     * @deprecated Crea una fecha que representa el 1° de enero de 1900
     *
     * @since 1.0
     */
    public Fecha()
    {
        this(1, 1, 1900);
    }

    /**
     * Regresa la representación String de esta fecha.
     *
     * @return La representación String de esta fecha.
     *
     * @since 1.0
     *
     */
    public String mostrarFecha()
    {
        return String.format("%d de %s de %d", dia, meses[mes - 1].toLowerCase(), anio);
    }

}
