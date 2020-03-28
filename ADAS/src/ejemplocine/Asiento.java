package ejemplocine;

import static java.lang.String.format;

/**
 *
 * @author Mohammed
 */
public class Asiento
{

    private Cliente cliente;
    private boolean ocupado;
    private char posicionLetra;
    private int posicionFila;

    public Asiento(boolean ocupado, Cliente cliente, char posicionLetra, int posicionFila)
    {
        this.ocupado = ocupado;
        this.cliente = cliente;
        this.posicionLetra = posicionLetra;
        this.posicionFila = posicionFila;
    }

    public boolean isOcupado()
    {
        return ocupado;
    }

    public void setOcupado(boolean ocupado)
    {
        this.ocupado = ocupado;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public char getPosicionLetra()
    {
        return posicionLetra;
    }

    public void setPosicionLetra(char posicionLetra)
    {
        this.posicionLetra = posicionLetra;
    }

    public int getPosicionFila()
    {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila)
    {
        this.posicionFila = posicionFila;
    }

    @Override
    public String toString()
    {
        return format("[%c : %d] %-17s $%-10.2f", posicionLetra, posicionFila, cliente.getNombre(), cliente.getSaldo());
    }

}
