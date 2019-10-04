package ejer1_15;

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
            banco.addCustomer(nombres[RAND.nextInt(nombres.length)], apellidos[RAND.nextInt(apellidos.length)], Math.random() * 1000);

            porDepositar = Math.random() * 10000;
            porRetirar = Math.random() * 10000;

            System.out.printf("%-40s(Saldo actual: $%,.2f)", String.format("\nCliente %02d", i + 1), banco.getCustomer(i).getCuenta().getBalance());

            statusDeposito = banco.getCustomer(i).getCuenta().deposit(porDepositar);

            System.out.printf("%-40s(Saldo actual: $%,.2f)", String.format("\nSe ha depositado $%,.2f", porDepositar), banco.getCustomer(i).getCuenta().getBalance());

            statusRetiro = banco.getCustomer(i).getCuenta().withdraw(porRetirar);

            System.out.printf("%-40s(Saldo actual: $%,.2f)\nSTATUS:\n", String.format("\nSe ha tratado de retirar $%,.2f", porRetirar), banco.getCustomer(i).getCuenta().getBalance());

            System.out.println(statusDeposito ? "Dinero depositado correctamente." : "El dinero no se pude depositar.");
            System.out.println(statusRetiro ? "Dinero retirado correctamente." : "El dinero no se pudo retirar.");

        }

        System.out.println(banco);

    }

}
