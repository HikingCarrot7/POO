package ejemplocine;

import static java.lang.String.format;

/**
 *
 * @author Mohammed
 */
public class Cliente
{

    private double saldo;
    private String nombre;

    public Cliente(String nombre, double saldo)
    {
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public double getSaldo()
    {
        return saldo;
    }

    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString()
    {
        return format("%s", getNombre());
    }

}
