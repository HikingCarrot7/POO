package ejemploregistrosempleados;

/**
 *
 * @author Mohammed
 */
public class Horario
{

    private IntervaloTiempo intervaloLV, intervaloS, intervaloD;

    public Horario()
    {
        intervaloLV = new IntervaloTiempo();
        intervaloS = new IntervaloTiempo();
        intervaloD = new IntervaloTiempo();
    }

    public void setHorarioLunesAViernes(int horasInicio, int minutosInicio, int horasTermina, int minutosTermina)
    {
        this.intervaloLV = new IntervaloTiempo(horasInicio, minutosInicio, horasTermina, minutosTermina);

    }

    public void setHorarioSabado(int horasInicio, int minutosInicio, int horasTermina, int minutosTermina)
    {
        this.intervaloS = new IntervaloTiempo(horasInicio, minutosInicio, horasTermina, minutosTermina);
    }

    public void setHorarioDomingo(int horasInicio, int minutosInicio, int horasTermina, int minutosTermina)
    {
        this.intervaloD = new IntervaloTiempo(horasInicio, minutosInicio, horasTermina, minutosTermina);
    }

    @Override
    public String toString()
    {
        return "\nHorario de lunes a viernes: " + intervaloLV
                + (intervaloS.getHorasInicio() == 0 ? "" : "\nHorario sábado: " + intervaloS)
                + (intervaloD.getHorasInicio() == 0 ? "" : "\nHorario domingo: " + intervaloD);

    }

    private class IntervaloTiempo
    {

        private int horasInicio, minutosInicio, horasTermina, minutosTermina;

        public IntervaloTiempo(int horasInicio, int minutosInicio, int horasTermina, int minutosTermina)
        {
            this.horasInicio = horasInicio;
            this.minutosInicio = minutosInicio;
            this.horasTermina = horasTermina;
            this.minutosTermina = minutosTermina;

        }

        public IntervaloTiempo()
        {
            this(0, 0, 0, 0);
        }

        public int getHorasInicio()
        {
            return horasInicio;
        }

        public int getMinutosInicio()
        {
            return minutosInicio;
        }

        public int getHorasTermina()
        {
            return horasTermina;
        }

        public int getMinutosTermina()
        {
            return minutosTermina;
        }

        @Override
        public String toString()
        {
            return String.format("Inicio: %02d : %02d   Termina %02d : %02d", getHorasInicio(), getMinutosInicio(), getHorasTermina(), getMinutosTermina());
        }

    }

}
