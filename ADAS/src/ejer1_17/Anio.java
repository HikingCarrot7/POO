package ejer1_17;

/**
 *
 * @author Ricardo Nicolás Canul Ibarra
 */
public class Anio
{

    private Mes[] meses;
    private String[] nombreMeses =
    {
        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
    };
    private int[] diasMeses =
    {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public Anio()
    {
        meses = new Mes[12];

        for (int i = 0; i < meses.length; i++)
            meses[i] = new Mes(diasMeses[i]);

    }

    public double getMaxTempMes(int mes)
    {
        return (mes - 1 >= 0 && mes - 1 <= 11) ? meses[mes - 1].getMaximaTempMes() : 0;
    }

    public double getMinTempMes(int mes)
    {
        return (mes - 1 >= 0 && mes - 1 <= 11) ? meses[mes - 1].getMinimaTempMes() : 0;
    }

    public double getMediaAnual()
    {
        double tempTotal = 0;

        for (Mes mes : meses)
            tempTotal += mes.getMediaTemperaturaMes();

        return tempTotal / meses.length;

    }

    public void setTempDiasMes(double[] tempDiasMes, int index)
    {
        if (index - 1 >= 0 && index - 1 <= 12)
            meses[index].setTempDias(tempDiasMes);

    }

    public int[] getDiasMeses()
    {
        return diasMeses;
    }

    public Mes[] getMeses()
    {
        return meses;
    }

    public String[] getNombreMeses()
    {
        return nombreMeses;
    }

    public void setMeses(Mes[] meses)
    {
        this.meses = meses;
    }

}
