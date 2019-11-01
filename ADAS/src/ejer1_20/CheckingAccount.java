package ejer1_20;

/**
 *
 * @author A15001169
 */
public class CheckingAccount extends Account
{

    private double overdraftAmount;

    public CheckingAccount(double balance, double overdraftamount)
    {
        super(balance);

        this.overdraftAmount = overdraftamount;

    }

    public CheckingAccount(double balance)
    {
        super(balance);

        overdraftAmount = 0;

    }

    @Override
    public void withdraw(double amount) throws OverdraftException
    {
        if (getBalance() + getOverdraftAmount() >= amount)

            if (getBalance() < amount)
            {
                overdraftAmount -= amount - getBalance();
                setBalance(0);

            } else
                setBalance(getBalance() - amount);
        else
            throw new OverdraftException("Insufficient funds for overdraft protection. Deficit: ", amount - (getBalance() + getOverdraftAmount()));

    }

    public double getOverdraftAmount()
    {
        return overdraftAmount;
    }

}
