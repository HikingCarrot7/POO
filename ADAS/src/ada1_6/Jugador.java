package ada1_6;

import java.util.Scanner;

/**
 * Clase Jugador.
 *
 * @author Ricardo Nicolás Canul Ibarra.
 */
public class Jugador
{

    private TragaMonedas tragaMonedas;
    private final Scanner IN;

    public Jugador(TragaMonedas tragaMonedas)
    {
        IN = new Scanner(System.in);
        this.tragaMonedas = tragaMonedas;
    }

    /**
     * Permite al jugador insertar el dinero total que usará durante toda su sesión de juego.
     */
    public void insertarMonedasJuego()
    {

        boolean dineroValido;
        double dineroJugador = 0;

        do
        {
            System.out.println("Cantidad de dinero para jugar (en dólares): ");
            String dinero = IN.nextLine();

            dineroValido = validarEntrada(dinero, "([0-9]+)*(0*.(25|5|75)0*)?"); // Se valida que sea correcta la cantidad de dinero que se inserta por medio de una expresión regular.

            if (dineroValido)
                dineroJugador = Double.parseDouble(dinero);
            else
                System.out.println("\nDinero inválido!");

        } while (!dineroValido);

        tragaMonedas.setNMonedasInicial(tragaMonedas.convertirDineroAMonedas(dineroJugador)); // Valor de monedas inicial.
        tragaMonedas.setNMonedasRestantes(tragaMonedas.convertirDineroAMonedas(dineroJugador)); // Monedas restantes del jugador.
        insertarMonedasJugada(); // Insertar monedas POR apuesta.

    }

    /**
     * Pide al jugador que inserte las monedas que apostará por jugada.
     */
    public void insertarMonedasJugada()
    {
        boolean monedasValidas;
        String monedasPorApostar;

        System.out.print("\nMonedas totales para jugar: " + tragaMonedas.getNMonedasRestantes()); //Monedas totales del jugador.

        do
        {
            System.out.println("\nMonedas a apostar (presione \"0\" para salir): ");
            monedasPorApostar = IN.nextLine();

            if (monedasPorApostar.equals("0")) //Si se presiona el "0" el juego termina.
                break;

            monedasValidas = validarEntrada(monedasPorApostar, "^[0-4]+$"); //Validamos por medio de una expresión regular si la cantidad de monedas por apuesta es correcta.

            if (monedasValidas)
            {
                int monedasApostadas = Integer.parseInt(monedasPorApostar);

                tragaMonedas.setNMonedasApuesta(monedasApostadas); // Se establecen las monedas para esta apuesta.

                if (tragaMonedas.validarApuesta()) // Se valida que hayan monedas sufiecientes en el saldo del jugador para hacer esta apuesta.
                {
                    tragaMonedas.setNMonedasRestantes(tragaMonedas.getNMonedasRestantes() - monedasApostadas); // Se restan las monedas disponibles del jugador.
                    tragaMonedas.setMonedasMaquina(tragaMonedas.getMonedasMaquina() + monedasApostadas); // Se añaden las monedas a la maquina.
                    tragaMonedas.ejecutarJuego(); // Se ejecuta la jugada.

                } else
                    System.out.println("\nMonedas insuficientes para hacer apuesta, inténtelo de nuevo");

            } else
                System.out.println("\nMonedas inválidas, sólo puede insertar entre 1 - 4 monedas por apuesta");

        } while (tragaMonedas.getNMonedasRestantes() != 0 && !tragaMonedas.sinDinero()); // Se repite hasta que se acabe el saldo del jugador o la máquina se quede sin dinero.

        if (tragaMonedas.sinDinero())
            System.out.println("\nLo sentimos, la máquina se quedó sin dinero!");

        tragaMonedas.calcularGanancia(); // Se calculan las ganancias.

    }

    /**
     * Valida si el texto especificado concuerda con la expresión regular especificada.
     *
     * @param text El texto a validar.
     * @param regex La expresión regular.
     *
     * @return <code>true</code> el texto concuerda con la expresión regular o <code>false</code> en caso contrario.
     *
     */
    private boolean validarEntrada(String text, String regex)
    {
        return text.matches(regex);
    }

}
