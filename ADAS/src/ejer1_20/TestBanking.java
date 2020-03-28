package ejer1_20;

import static java.lang.Math.random;
import static java.lang.String.format;
import static java.lang.System.out;
import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class TestBanking
{

    private final Bank banco;
    private final String[] nombres =
    {
        "Nicolás", "Edwin", "Javier", "Carlos", "Juan", "Emmanuel", "Oscar"
    };

    public String[] apellidos =
    {
        "Canul", "Ibarra", "Ajas", "Santos", "López", "Moreno", "Chable"
    };

    public TestBanking()
    {
        banco = new Bank();
    }

    public static void main(String[] args)
    {
        new TestBanking().gestionarClientes();
    }

    public void gestionarClientes()
    {
        Random rand = new Random();
        double porDepositar, porRetirar;
        boolean tipoCuenta;

        for (int i = 0; i < banco.getClientes().length; i++)
        {
            tipoCuenta = rand.nextInt(2) == 0;

            banco.addCustomer(tipoCuenta ? new CheckingAccount(400, 200) : new SavingsAccount(400, 0.03),
                    nombres[rand.nextInt(nombres.length)],
                    apellidos[rand.nextInt(apellidos.length)]);

            Customer customer = banco.getCustomer(i);
            porDepositar = random() * 1000;
            out.println(customer);

            for (int j = 0; j < 3; j++)
            {
                porRetirar = random() * 500;

                out.println(format("%-20s%-15s%-15s : withdraw $%,.2f",
                        customer.getCuenta() instanceof CheckingAccount ? "CheckingAccount" : "SavingsAccount",
                        customer.getNombre(),
                        customer.getApellido(), porRetirar));

                try
                {
                    customer.getCuenta().withdraw(porRetirar);

                } catch (OverdraftException ex)
                {
                    out.println(ex.getMessage());
                    break;
                }

            }

            out.println(format("%-20s%-15s%-15s : deposit $%,.2f",
                    customer.getCuenta() instanceof CheckingAccount ? "CheckingAccount" : "SavingsAccount",
                    customer.getNombre(),
                    customer.getApellido(), porDepositar));

            customer.getCuenta().deposit(porDepositar);

            out.println(format("%-20s%-15s%-15s has a "
                    + (customer.getCuenta() instanceof CheckingAccount ? "checking" : "savings") + " balance of $%,.2f", "Customer",
                    customer.getNombre(),
                    customer.getApellido(),
                    customer.getCuenta().getBalance()));

            out.println("\t\t\t\t-----------------------");
        }

        out.println(banco);
    }

}
