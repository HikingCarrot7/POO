package ada1_6;

import java.util.Random;

/**
 *
 * @author HikingCarrot7
 */
public class TragaMonedas
{

    public static final double VALORMONEDAS = 0.25; // Valor de las monedas virtuales de las máquina.
    private final Random RAND; // Generar número aleatorios.
    private double MonedasMaquina; // Dinero disponible en la máquina.
    private int nMonedasInicial; // Monedas iniciales del jugador.
    private int nMonedasRestantes; // Monedas restantes del jugador (totales).
    private int nMonedasApuesta; // Monedas por apuesta del jugador.

    /**
     * Valores de las piezas.
     */
    private enum Piezas
    {

        CAMPANA,
        UVA,
        CEREZA

    }

    /**
     * Constructor de la máquina.
     *
     * @param monedasMaquina Las monedas iniciales de la máquina.
     */
    public TragaMonedas(double monedasMaquina)
    {
        this.MonedasMaquina = monedasMaquina;
        RAND = new Random();

    }

    /**
     * Ejecuta una jugada.
     *
     */
    public void ejecutarJuego()
    {
        if (!sinDinero()) // Ejecutamos la jugada si hay dinero.
            realizarJugada();
    }

    /**
     * Realiza la jugada por apuesta.
     */
    public void realizarJugada()
    {
        Piezas ranura1 = Piezas.values()[RAND.nextInt(Piezas.values().length)];
        Piezas ranura2 = Piezas.values()[RAND.nextInt(Piezas.values().length)];
        Piezas ranura3 = Piezas.values()[RAND.nextInt(Piezas.values().length)];
        int monedasGanadas = ganaCantVecesMontoApostado(ranura1, ranura2, ranura3); // Cantidad de veces que se multiplicará las monedas apostadas del jugador para esta jugada.

        // Actualizamos las monedas restantes del jugador y de la máquina.
        nMonedasRestantes += nMonedasApuesta * monedasGanadas > getMonedasMaquina() ? getMonedasMaquina() : nMonedasApuesta * monedasGanadas;
        setMonedasMaquina(getMonedasMaquina() - monedasGanadas);

        // Imprimimos el tablero.
        imprimirTablero(ranura1, ranura2, ranura3);

        // Resumen de la jugada.
        System.out.println(String.format("\n%-15s%d moneda(s)\n%-15s%d moneda(s)", "Ganas:", nMonedasApuesta * monedasGanadas, "Restantes:", getNMonedasRestantes()));

    }

    /**
     * Imprime el tablero por consola.
     *
     * @param ranura1 La ranura 1 de la salida de la máquina.
     * @param ranura2 La ranura 2 de la salida de la máquina.
     * @param ranura3 La ranura 3 de la salida de la máquina.
     */
    private void imprimirTablero(Piezas ranura1, Piezas ranura2, Piezas ranura3)
    {
        String text = "\t";

        for (int i = 0; i < 52; i++)
            text += "-";

        text += String.format("\n\t| %-15s| %-15s| %-15s|\n\t", ranura1, ranura2, ranura3);

        for (int i = 0; i < 52; i++)
            text += "-";

        System.out.println(text);

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
     * Calcula las ganancias por juego.
     *
     */
    public void calcularGanancia()
    {
        int aux = getNMonedasRestantes() - nMonedasInicial; // Si el al hacer esta resta el número queda negativo, entonces el jugador perdió dinero.
        int gananciasMonedas = aux < 0 ? aux * -1 : aux;

        System.out.println(String.format("\n%-25s%d moneda(s)\n%s",
                "Quedaron por jugar:",
                getNMonedasRestantes(),
                String.format("%-25s%d moneda(s) ($%,.2f dólares)", aux < 0 ? "El jugador perdió:" : "El jugador ganó:", gananciasMonedas, convertirMonedasADinero(gananciasMonedas))));

    }

    /**
     * Retorna si la cantidad de monedas a apostar es adecuada con respecto al saldo del jugador.
     *
     * @return <code>true</code> si las monedas apostadas son las adecuadas <code>false</code> en caso contrario.
     */
    public boolean validarApuesta()
    {
        return nMonedasApuesta <= nMonedasRestantes;
    }

    /**
     * Convierte el dinero del jugador (dólares) a monedas de la máquina.
     *
     * @param dineroDolares Los dólares a convertir en monedas virtuales.
     *
     * @return El dinero del jugador en monedas virtuales de la máquina.
     */
    public int convertirDineroAMonedas(double dineroDolares)
    {
        return (int) (dineroDolares / VALORMONEDAS);
    }

    /**
     * Convertimos las monedas a dinero (dólares).
     *
     * @param monedas Las monedas a convertir a dólares.
     *
     * @return La cantidad de dólares que representan la monedas.
     */
    public double convertirMonedasADinero(int monedas)
    {
        return monedas * VALORMONEDAS;
    }

    /**
     * Establece las monedas por apuesta.
     *
     * @param NMonedasApuesta Las monesdas por establecer por apuesta.
     */
    public void setNMonedasApuesta(int NMonedasApuesta)
    {
        this.nMonedasApuesta = NMonedasApuesta;
    }

    /**
     * Establece las monedas restantes para el jugador.
     *
     * @param NMonedasRestantes Las monedas que le quedan al jugador para jugar.
     */
    public void setNMonedasRestantes(int NMonedasRestantes)
    {
        this.nMonedasRestantes = NMonedasRestantes;
    }

    /**
     * Retorna las monedas restantes del jugador.
     *
     * @return Las monedas restantes del jugador.
     */
    public int getNMonedasRestantes()
    {
        return nMonedasRestantes;
    }

    /**
     * Establece las monedas iniciales del jugador.
     *
     * @param NMonedasInicial Las monedas iniciales del jugador.
     */
    public void setNMonedasInicial(int NMonedasInicial)
    {
        this.nMonedasInicial = NMonedasInicial;
    }

    /**
     * Establece las monedas de máquina.
     *
     * @param MonedasMaquina Las monedas a establecer de la máquina.
     */
    public void setMonedasMaquina(double MonedasMaquina)
    {
        this.MonedasMaquina = MonedasMaquina < 0 ? 0 : MonedasMaquina;
    }

    /**
     * Retorna las monedas de las máquina.
     *
     * @return Las monedas de las máquina.
     */
    public double getMonedasMaquina()
    {
        return MonedasMaquina;
    }

    /**
     * Retorna si la máquina tiene dinero.
     *
     * @return Si la máquina tiene dinero.
     */
    public boolean sinDinero()
    {
        return MonedasMaquina <= 0;
    }

}
