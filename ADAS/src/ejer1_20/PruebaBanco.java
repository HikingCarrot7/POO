package ejer1_20;

import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class PruebaBanco
{

    private Bank banco;
    private String[] nombres =
    {
        "Nicolás", "Edwin", "Javier", "Carlos", "Juan", "Emmanuel", "Oscar"
    };

    public String[] apellidos =
    {
        "Canul", "Ibarra", "Ajas", "Santos", "López", "Moreno", "Chable"
    };

    public PruebaBanco()
    {
        banco = new Bank();

    }

    public static void main(String[] args)
    {
        new PruebaBanco().gestionarClientes();
    }

    public void gestionarClientes()
    {
        Random rand = new Random();
        double porDepositar, porRetirar;
        boolean tipoCuenta;

        for (int i = 0; i < 20; i++)
        {

            tipoCuenta = rand.nextInt(2) == 0;

            banco.addCustomer(tipoCuenta ? new CheckingAccount(400, 200) : new SavingsAccount(400, 0.03),
                    nombres[rand.nextInt(nombres.length)],
                    apellidos[rand.nextInt(apellidos.length)]);

            Customer customer = banco.getCustomer(i);

            porDepositar = Math.random() * 1000;
            porRetirar = Math.random() * 1000;

            System.out.println(customer);

            System.out.println(String.format("%-20s%-15s%-15s : withdraw $%,.2f",
                    customer.getCuenta() instanceof CheckingAccount ? "CheckingAccount" : "SavingsAccount",
                    customer.getNombre(),
                    customer.getApellido(), porRetirar));

            try
            {
                customer.getCuenta().withdraw(porRetirar);

            } catch (OverdraftException ex)
            {
                System.out.println(ex.getMessage());
            }

            System.out.println(String.format("%-20s%-15s%-15s : deposit $%,.2f",
                    customer.getCuenta() instanceof CheckingAccount ? "CheckingAccount" : "SavingsAccount",
                    customer.getNombre(),
                    customer.getApellido(), porDepositar));

            banco.getCustomer(i).getCuenta().deposit(porDepositar);

            System.out.println(String.format("%-20s%-15s%-15s has a "
                    + (customer.getCuenta() instanceof CheckingAccount ? "checking" : "savings") + " balance of $%,.2f", "Customer",
                    customer.getNombre(),
                    customer.getApellido(),
                    customer.getCuenta().getBalance()));

            System.out.println("\t\t\t\t-----------------------");

        }

        System.out.println(banco);

    }

}
