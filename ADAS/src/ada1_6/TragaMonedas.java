package ada1_6;

import java.util.Random;

/**
 *
 * @author HikingCarrot7
 */
public class TragaMonedas
{

    public static final double VALORMONEDAS = 0.25;
    private final Random RAND;
    private double dineroMaquina; // Dinero disponible en la máquina.
    private int nMonedasInicial; // Monedas iniciales del jugador.
    private int nMonedasRestantes; // Monedas restantes del jugador (totales).
    private int nMonedasApuesta; // Monedas por apuesta del jugador.

    public TragaMonedas(double dineroMaquina)
    {
        this.dineroMaquina = dineroMaquina;
        RAND = new Random();

    }

    private enum Piezas
    {

        CAMPANA,
        UVA,
        CEREZA
    }

    public void solicitarApuesta(int monedasApostadas)
    {
        if (validarApuesta())
            ejecutarJuego();
    }

    /**
     * Ejecuta una jugada.
     *
     */
    public void ejecutarJuego()
    {

        if (!sinDinero())
            realizarJugada();
        else
            System.out.println("\nLo sentimos, la máquina se quedó sin dinero!");
    }

    /**
     * Realiza la jugada por apuesta.
     */
    public void realizarJugada()
    {
        Piezas ranura1 = Piezas.values()[RAND.nextInt(3)];
        Piezas ranura2 = Piezas.values()[RAND.nextInt(3)];
        Piezas ranura3 = Piezas.values()[RAND.nextInt(3)];
        int monedasGanadas = ganaCantVecesMontoApostado(ranura1, ranura2, ranura3);

        nMonedasRestantes += nMonedasApuesta * monedasGanadas;

        System.out.println(String.format("\nPiezas:\n%-15s%-15s%s", ranura1, ranura2, ranura3));
        System.out.println(String.format("\nGanas: %d Moneda(s)\nTus monedas restantes: %d", nMonedasApuesta * monedasGanadas, getNMonedasRestantes()));

    }

    /**
     * Retorna la cantidad de veces que se multiplica el monto apostado por el jugador.
     *
     * @param ranura1 La ranura 1 de la salida de la máquina.
     * @param ranura2 La ranura 2 de la salida de la máquina.
     * @param ranura3 La ranura 3 de la salida de la máquina.
     *
     * @return La cantidad de veces por la que se multiplica el monto apostado según la pieza que se genere en las ranuras.
     */
    private int ganaCantVecesMontoApostado(Piezas ranura1, Piezas ranura2, Piezas ranura3)
    {
        if (ranura1.equals(Piezas.CAMPANA) && ranura2.equals(Piezas.CAMPANA) && ranura3.equals(Piezas.CAMPANA))
            return 10;

        else if (ranura1.equals(Piezas.UVA) && ranura2.equals(Piezas.UVA) && ranura3.equals(Piezas.UVA))
            return 7;

        else if (ranura1.equals(Piezas.CEREZA) && ranura2.equals(Piezas.CEREZA) && ranura3.equals(Piezas.CEREZA))
            return 5;

        else if ((ranura1.equals(Piezas.CEREZA) && ranura2.equals(Piezas.CEREZA))
                || (ranura1.equals(Piezas.CEREZA) && ranura3.equals(Piezas.CEREZA))
                || (ranura2.equals(Piezas.CEREZA) && ranura3.equals(Piezas.CEREZA)))
            return 3;

        else if (ranura1.equals(Piezas.CEREZA) || ranura2.equals(Piezas.CEREZA) || ranura3.equals(Piezas.CEREZA))
            return 1;

        return 0;

    }

    /**
     * Retorna las ganancias por juego.
     *
     * @param NMonedas
     * @return
     */
    public double calcularGanancia(int NMonedas)
    {
        return 1;
    }

    public boolean validarApuesta()
    {
        return nMonedasApuesta <= nMonedasRestantes;
    }

    public void setNMonedasApuesta(int NMonedasApuesta)
    {
        this.nMonedasApuesta = NMonedasApuesta;
    }

    public void setNMonedasRestantes(int NMonedasRestantes)
    {
        this.nMonedasRestantes = NMonedasRestantes;
    }

    public int getNMonedasRestantes()
    {
        return nMonedasRestantes;
    }

    public void setNMonedasInicial(int NMonedasInicial)
    {
        this.nMonedasInicial = NMonedasInicial;
    }

    public void setDineroMaquina(double dineroMaquina)
    {
        this.dineroMaquina = dineroMaquina;
    }

    private boolean sinDinero()
    {
        return dineroMaquina == 0;
    }

}
