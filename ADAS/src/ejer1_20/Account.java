package ejer1_20;

/**
 *
 * @author HikingCarrot7
 */
public class Account
{

    private double balance;

    public Account(double balance)
    {
        this.balance = balance;
    }

    public void deposit(double balance)
    {
        if (balance >= 0)
            setBalance(getBalance() + balance);
    }

    public void withdraw(double dineroRetirar) throws OverdraftException
    {
        if (getBalance() >= dineroRetirar)
            setBalance(getBalance() - dineroRetirar);

        else
            throw new OverdraftException("Insufficient funds. Deficit: ", dineroRetirar - getBalance());
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
