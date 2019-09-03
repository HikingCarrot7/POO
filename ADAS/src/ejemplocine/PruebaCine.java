package ejemplocine;

import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class PruebaCine
{

    private final Cine cine;
    private final Random rand;
    private final String[] nombres =
    {
        "Nicolás", "Javier", "Eusebio", "Carlos", "Emmanuel", "Guillermo"
    };

    private final String[] apellidos =
    {
        "Canul", "Chim", "Cemé", "Ajas", "Dzul", "Álvarez", "Collí"
    };

    private final String[] peliculas =
    {
        "Shrek", "Shrek 2", "Shrek 3", "Shrek 4", "Shrek 5"
    };

    public PruebaCine()
    {
        rand = new Random();
        cine = new Cine(peliculas[rand.nextInt(peliculas.length)], rand.nextDouble() * 70 + 30);

    }

    public void gestionarCine()
    {
        System.out.printf("La película que se está reproduciendo es: %-10s Precio: $%,.2f\n\n", cine.getPelicula(), cine.getPrecioPelicula());

        while (!cine.cineLleno())
        {
            Cliente cliente = new Cliente(String.format("%s %s", nombres[rand.nextInt(nombres.length)], apellidos[rand.nextInt(apellidos.length)]), rand.nextDouble() * 100 + 10);

            int columna = rand.nextInt(10), fila = rand.nextInt(5);

            if (cliente.getSaldo() < cine.getPrecioPelicula())
                System.out.printf("El cliente %-18s trató de entrar con: $%,.2f\n", cliente.getNombre(), cliente.getSaldo());

            else if (cine.obtenerAsientos()[fila][columna].isOcupado())
                System.out.printf("El cliente %-18s trató de entrar a un asiento ocupado con: $%,.2f\n", cliente.getNombre(), cliente.getSaldo());

            else
                cine.ocuparAsiento(cliente, (char) (columna + 65), fila);

        }

        System.out.println("");

        cine.imprimirCine();

    }

    public static void main(String[] args)
    {
        new PruebaCine().gestionarCine();
    }

}
