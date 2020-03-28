package ejer1_14;

import galapagos.Turtle;
import java.awt.Color;
import static java.awt.Color.black;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mohammed
 */
public class GraficaBarras
{

    private final Scanner IN;

    public GraficaBarras()
    {
        IN = new Scanner(in);
    }

    public static void main(String[] args)
    {
        GraficaBarras graficaBarras = new GraficaBarras();

        graficaBarras.imprimirGraficas(graficaBarras.pedirDatos());

    }

    public int[] pedirDatos()
    {
        int[] valores = new int[5];

        for (int i = 0; i < valores.length; i++)
        {
            out.printf("\nDigite el valor de la barra %d\n", i + 1);
            valores[i] = IN.nextInt();

        }

        return valores;

    }

    public void imprimirGraficas(int[] valores)
    {

        Turtle miTurtle = new Turtle();
        float anchoBarras = 400 / valores.length;

        for (int i = 0; i < valores.length; i++)
        {

            if (i == 0)
            {
                miTurtle.penColor(black);
                miTurtle.speed(1000);
                miTurtle.turn(180);
                miTurtle.move(200);

            } else
                miTurtle.turn(180);

            miTurtle.penColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            miTurtle.turn(-90);
            miTurtle.move(valores[i] * 1.5);
            miTurtle.turn(-90);
            miTurtle.move(anchoBarras);
            miTurtle.turn(-90);
            miTurtle.move(valores[i] * 1.5);
            miTurtle.turn(90);

        }

        miTurtle.penColor(black);
        miTurtle.turn(180);
        miTurtle.move(200);

    }

}
