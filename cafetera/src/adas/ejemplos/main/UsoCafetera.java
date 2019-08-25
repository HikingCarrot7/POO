package adas.ejemplos.main;

import adas.ejemplos.maquina.Cafetera;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author GrajalesMag
 */
public class UsoCafetera
{

    public static void main(String[] args)
    {

        try
        {
            File file = new File("res/DineroCafetera.txt");
            Scanner in = new Scanner(new FileReader(file));

            String[] monedas = in.next().split(";");

            new Cafetera(Integer.parseInt(monedas[0]), Integer.parseInt(monedas[1]), Integer.parseInt(monedas[2])).despacharCliente();

        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
