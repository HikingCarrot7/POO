package ejer1_20;

import ejer1_15.*;

/**
 *
 * @author HikingCarrot7
 */
public class Cliente
{

    private Cuenta cuenta;
    private String nombre;
    private String apellido;

    public Cliente(String nombre, String apellido, double balance)
    {
        this.nombre = nombre;
        this.apellido = apellido;

        cuenta = new Cuenta(balance);

    }

    public Cuenta getCuenta()
    {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta)
    {
        this.cuenta = cuenta;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String apellido)
    {
        this.apellido = apellido;
    }

    @Override
    public String toString()
    {
        return String.format("%-15s%-15s tiene un saldo de $%,.2f", getNombre(), getApellido(), getCuenta().getBalance());
    }

}
