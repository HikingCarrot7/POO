package ejer1_20;

/**
 *
 * @author HikingCarrot7
 */
public class Bank
{

    private int numberOfCustomers;
    private Customer[] clientes;

    public Bank()
    {
        numberOfCustomers = 0;
        clientes = new Customer[10];

    }

    public void addCustomer(Account account, String nombre, String apellido)
    {
        clientes[getNumOfCustomers()] = new Customer(account, nombre, apellido);

        numberOfCustomers++;

    }

    public int getNumOfCustomers()
    {
        return numberOfCustomers;
    }

    public Customer getCustomer(int indexCustomer)
    {
        return clientes[indexCustomer];
    }

    public Customer[] getClientes()
    {
        return clientes;
    }

    @Override
    public String toString()
    {
        String resumen = "";

        resumen += "\n\t\t\t\t\t<<Clientes registrados en este banco>>\n\n";

        for (int i = 0; i < clientes.length; i++)
            resumen += String.format("%02d.- %s\n", i + 1, clientes[i]);

        return resumen;

    }

}
