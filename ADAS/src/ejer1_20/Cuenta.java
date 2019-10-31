package ejer1_20;

import ejer1_15.*;

/**
 *
 * @author HikingCarrot7
 */
public class Cuenta
{

    private double balance;

    public Cuenta(double balance)
    {
        this.balance = balance;
    }

    public boolean deposit(double balance)
    {
        if (balance >= 0)
        {
            setBalance(getBalance() + balance);

            return true;

        } else
            return false;

    }

    public boolean withdraw(double dineroRetirar)
    {
        if (getBalance() >= dineroRetirar)
        {
            setBalance(getBalance() - dineroRetirar);

            return true;

        } else
            return false;

    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance < 0 ? 0 : balance;
    }

}
