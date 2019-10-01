package ejer1_13;

import java.util.Random;

/**
 *
 * @author Mohammed
 */
public final class GeneradorPreguntas
{

    private final Random RAND;
    private Fraccion[] fracciones1, fracciones2;
    private TiposDeFraccion[] tipoDeFracciones;

    public GeneradorPreguntas()
    {
        RAND = new Random();
        fracciones1 = new Fraccion[10];
        fracciones2 = new Fraccion[10];
        tipoDeFracciones = new TiposDeFraccion[10];

        generarTipoFracciones();

        generarPreguntas(fracciones1);
        generarPreguntas(fracciones2);

    }

    public void generarTipoFracciones()
    {
        for (int i = 0; i < tipoDeFracciones.length; i++)
            tipoDeFracciones[i] = TiposDeFraccion.values()[RAND.nextInt(4)];

    }

    public void generarPreguntas(Fraccion[] fracciones)
    {
        for (int i = 0; i < fracciones.length; i++)
            fracciones[i] = new Fraccion(1 + RAND.nextInt(25), 1 + RAND.nextInt(25)).simplifica();
    }

    public Fraccion[] getFracciones1()
    {
        return fracciones1;
    }

    public Fraccion[] getFracciones2()
    {
        return fracciones2;
    }

    public TiposDeFraccion[] getTipoDeFracciones()
    {
        return tipoDeFracciones;
    }

}
