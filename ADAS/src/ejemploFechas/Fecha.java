package ejemploFechas;

/**
 *
 * @author HikingCarrot7
 */
public class Fecha
{

    private final int dia, mes, anio;

    public Fecha(int dia, int mes, int anio)
    {
        this.dia = dia;
        this.mes = mes <= 12 && mes >= 1 ? mes : 1;
        this.anio = anio;
    }

    public int getAnio()
    {
        return anio;
    }

    @Override
    public String toString()
    {
        return String.format("%d-%d-%d", anio, mes, dia);
    }

    public static Fecha[] ordenarFechas(Fecha[] fechas)
    {
        for (int i = 0; i < fechas.length - 1; i++)
            for (int j = i + 1; j < fechas.length; j++)
                if (fechas[i].getAnio() < fechas[j].getAnio())
                {
                    Fecha tempFecha = fechas[i];
                    fechas[i] = fechas[j];
                    fechas[j] = tempFecha;

                }

        return fechas;
    }
}
