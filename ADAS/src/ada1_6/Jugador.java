package ada1_6;

import java.util.Scanner;

/**
 *
 * @author HikingCarrot7
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
            System.out.println("Inserte la cantidad de dinero para jugar: ");
            String dinero = IN.nextLine();

            dineroValido = validarEntrada(dinero, "([0-9]+)*(0*.(25|5|75)0*)*");

            if (dineroValido)
                dineroJugador = Double.parseDouble(dinero);
            else
                System.out.println("\nDinero inválido!");

        } while (!dineroValido);

        tragaMonedas.setNMonedasInicial(tragaMonedas.convertirDineroAMonedas(dineroJugador));
        tragaMonedas.setNMonedasRestantes(tragaMonedas.convertirDineroAMonedas(dineroJugador));
        insertarMonedasJugada();

    }

    public void insertarMonedasJugada()
    {
        boolean monedasValidas;
        String monedasPorApostar;

        System.out.print("\nMonedas totales para jugar: " + tragaMonedas.getNMonedasRestantes());

        do
        {
            System.out.println("\nInserte las monedas que desea apostar en esta jugada (presione \"0\" para salir): ");
            monedasPorApostar = IN.nextLine();

            if (monedasPorApostar.equals("0"))
                break;

            monedasValidas = validarEntrada(monedasPorApostar, "^[0-4]+$");

            if (monedasValidas)
            {
                int monedasApostadas = Integer.parseInt(monedasPorApostar);

                tragaMonedas.setNMonedasApuesta(monedasApostadas);

                if (tragaMonedas.validarApuesta())
                {
                    tragaMonedas.setNMonedasRestantes(tragaMonedas.getNMonedasRestantes() - monedasApostadas);
                    tragaMonedas.setMonedasMaquina(tragaMonedas.getMonedasMaquina() + monedasApostadas);
                    tragaMonedas.setNMonedasApuesta(monedasApostadas);
                    tragaMonedas.ejecutarJuego();

                } else
                    System.out.println("\nMonedas insuficientes para hacer apuesta, inténtelo de nuevo");

            } else
                System.out.println("\nMonedas inválidas, sólo puede insertar entre 1 - 4 monedas por apuesta");

        } while (tragaMonedas.getNMonedasRestantes() != 0 && !tragaMonedas.sinDinero());

        if (tragaMonedas.sinDinero())
            System.out.println("\nLo sentimos, la máquina se quedó sin dinero!");

        tragaMonedas.calcularGanancia();

        System.out.println("\nGracias por jugar!");

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
