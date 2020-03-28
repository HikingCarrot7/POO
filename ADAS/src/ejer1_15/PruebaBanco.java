package ejer1_15;

import static java.lang.Math.random;
import static java.lang.String.format;
import static java.lang.System.out;
import java.util.Random;

/**
 *
 * @author Mohammed
 */
public class PruebaBanco
{

    private final Random RAND;
    private Banco banco;
    private String[] nombres =
    {
        "Nicolás", "Edwin", "Javier", "Carlos", "Juan", "Emmnuel", "Oscar"
    };

    public String[] apellidos =
    {
        "Canul", "Ibarra", "Ajas", "Santos", "López", "Moreno", "Chable"
    };

    public PruebaBanco()
    {
        RAND = new Random();
        banco = new Banco();

    }

    public static void main(String[] args)
    {
        new PruebaBanco().gestionarClientes();
    }

    public void gestionarClientes()
    {
        double porDepositar, porRetirar;
        boolean statusDeposito, statusRetiro;

        for (int i = 0; i < 20; i++)
        {
            banco.addCustomer(nombres[RAND.nextInt(nombres.length)], apellidos[RAND.nextInt(apellidos.length)], random() * 1000);

            porDepositar = random() * 10000;
            porRetirar = random() * 10000;

            out.printf("%-40s(Saldo actual: $%,.2f)", format("\nCliente %02d", i + 1), banco.getCustomer(i).getCuenta().getBalance());

            statusDeposito = banco.getCustomer(i).getCuenta().deposit(porDepositar);

            out.printf("%-40s(Saldo actual: $%,.2f)", format("\nSe ha depositado $%,.2f", porDepositar), banco.getCustomer(i).getCuenta().getBalance());

            statusRetiro = banco.getCustomer(i).getCuenta().withdraw(porRetirar);

            out.printf("%-40s(Saldo actual: $%,.2f)\nSTATUS:\n", format("\nSe ha tratado de retirar $%,.2f", porRetirar), banco.getCustomer(i).getCuenta().getBalance());

            out.println(statusDeposito ? "Dinero depositado correctamente." : "El dinero no se pude depositar.");
            out.println(statusRetiro ? "Dinero retirado correctamente." : "El dinero no se pudo retirar.");

        }

        out.println(banco);

    }

}
