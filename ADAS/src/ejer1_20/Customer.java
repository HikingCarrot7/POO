package ejer1_20;

import static java.lang.String.format;

/**
 *
 * @author HikingCarrot7
 */
public class Customer
{

    private Account account;
    private String nombre;
    private String apellido;

    public Customer(Account account, String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.account = account;
    }

    public Account getCuenta()
    {
        return account;
    }

    public void setCuenta(Account cuenta)
    {
        this.account = cuenta;
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
        if (account instanceof CheckingAccount)
            return format("%-20s%-15s%-15s has a checking balance of $%,.2f with a $%,.2f overdraft protection", "Customer",
                    getNombre(),
                    getApellido(),
                    getCuenta().getBalance(),
                    ((CheckingAccount) getCuenta()).getOverdraftAmount());

        return format("%-20s%-15s%-15s has a savings balance of $%,.2f", "Customer",
                getNombre(),
                getApellido(),
                getCuenta().getBalance());
    }

}
