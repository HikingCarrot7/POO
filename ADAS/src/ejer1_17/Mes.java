package ejer1_17;

/**
 *
 * @author Mohammed
 */
public class Mes
{

    private double[] tempDias;

    public Mes(int diasMes)
    {
        tempDias = new double[diasMes];
    }

    public double getMediaTemperaturaMes()
    {
        double sumaTotal = 0;

        for (double tempDia : tempDias)
            sumaTotal += tempDia;

        return sumaTotal / tempDias.length;

    }

    public double getMaximaTempMes()
    {
        double tempMax = tempDias[0];

        for (double tempDia : tempDias)
            if (tempDia > tempMax)
                tempMax = tempDia;

        return tempMax;

    }

    public double getMinimaTempMes()
    {
        double tempMin = tempDias[0];

        for (double tempDia : tempDias)
            if (tempDia < tempMin)
                tempMin = tempDia;

        return tempMin;

    }

    public double[] getTempDias()
    {
        return tempDias;
    }

    public void setTempDias(double[] tempDias)
    {
        this.tempDias = tempDias;
    }

    @Override
    public String toString()
    {
        String temps = "";

        for (double temp : tempDias)
            temps += String.format("%,.1f,", temp);

        return temps;

    }

}
