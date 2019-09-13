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
            System.out.println("\nInserte la cantidad de dinero para jugar: ");
            String dinero = IN.nextLine();

            dineroValido = validarEntrada(dinero, "[0-9]+(.(25|5|75)0*)*");

            if (dineroValido)
                dineroJugador = Double.parseDouble(dinero);
            else
                System.out.println("\nDinero inválido!");

        } while (!dineroValido);

        tragaMonedas.setNMonedasInicial(convertirDineroAMonedas(dineroJugador));
        tragaMonedas.setNMonedasRestantes(convertirDineroAMonedas(dineroJugador));
        insertarMonedasJugada();

    }

    public void insertarMonedasJugada()
    {
        boolean monedasValidas;
        String monedasPorApostar;

        do
        {
            System.out.println(String.format("\nMonedas totales: %-10s\nInserte las monedas que desea apostar en esta jugada: ", tragaMonedas.getNMonedasRestantes()));
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
                    tragaMonedas.setNMonedasApuesta(monedasApostadas);
                    tragaMonedas.ejecutarJuego();

                } else
                {
                    System.out.println("\nSe ha quedado sin monedas!");

                    break;
                }

            }

        } while (tragaMonedas.getNMonedasRestantes() != 0);

        tragaMonedas.calcularGanancia(1);

        System.out.println("Gracias por jugar!");

    }

    /**
     * Convierte el dinero del jugador (dólares) a fichas de la máquina.
     *
     * @return El dinero del jugador en fichas virtuales de la máquina.
     */
    private int convertirDineroAMonedas(double dineroJugador)
    {
        return (int) (dineroJugador / TragaMonedas.VALORMONEDAS);
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
