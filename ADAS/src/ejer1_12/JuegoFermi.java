package ejer1_12;

import java.util.Random;

/**
 *
 * @author HikingCarrot7
 */
public final class JuegoFermi
{

    private final Random RAND;
    private String[] pistas;
    private int[] numerosAleatorios;

    public JuegoFermi()
    {
        numerosAleatorios = new int[3];
        pistas = new String[3];

        RAND = new Random();

        generarNumerosAleatorios();

    }

    public void generarNumerosAleatorios()
    {
        boolean encontrado;
        int numAleatorio, indexNumerosAleatorios = 0;

        do
        {
            numAleatorio = RAND.nextInt(10);
            encontrado = false;

            for (int i = 0; i < numerosAleatorios.length; i++)
                if (numAleatorio == numerosAleatorios[i])
                    encontrado = true;

            if (!encontrado)
                numerosAleatorios[indexNumerosAleatorios++] = numAleatorio;

        } while (indexNumerosAleatorios < 3);

        for (int i = 0; i < numerosAleatorios.length; i++)
            System.out.printf("%d ", numerosAleatorios[i]);

    }

    public String[] obtenerPistasNumerosEntrada(int[] numerosEntrada)
    {

        for (int i = 0; i < numerosEntrada.length; i++)
            for (int j = 0; j < numerosAleatorios.length; j++)
                if (i == j && numerosEntrada[i] == numerosAleatorios[j])
                    pistas[j] = "Fermi";

                else if (numerosEntrada[i] == numerosAleatorios[j])
                    pistas[j] = "Pico";

        for (int i = 0; i < pistas.length; i++)
            if (pistas[i] == null)
                pistas[i] = "Nano";

        return pistas;

    }

    public boolean jugadorGana()
    {
        for (int i = 0; i < pistas.length; i++)
            if (!pistas[i].equals("Fermi"))
                return false;

        return true;

    }

}
