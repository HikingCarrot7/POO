package ejer1_15;

import static java.lang.String.format;

/**
 *
 * @author HikingCarrot7
 */
public class Banco
{

    private int numberOfCustomers;
    private Cliente[] clientes;

    public Banco()
    {
        numberOfCustomers = 0;
        clientes = new Cliente[20];

    }

    public void addCustomer(String nombre, String apellido, double balance)
    {
        clientes[getNumOfCustomers()] = new Cliente(nombre, apellido, balance);

        numberOfCustomers++;

    }

    public int getNumOfCustomers()
    {
        return numberOfCustomers;
    }

    public Cliente getCustomer(int indexCustomer)
    {
        return clientes[indexCustomer];
    }

    @Override
    public String toString()
    {
        String resumen = "";

        resumen += "\n\t<<Clientes registrados en este banco>>\n\n";

        for (int i = 0; i < clientes.length; i++)
            resumen += format("%02d.- %s\n", i + 1, clientes[i]);

        return resumen;

    }

}
