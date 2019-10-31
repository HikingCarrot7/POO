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
    public boolean withdraw(double dineroRetirar)
    {
        if (getBalance() >= dineroRetirar)
        {

            if (getBalance() < dineroRetirar)
            {
                overdraftAmount -= dineroRetirar - balance;
                balance = 0;

            } else
                balance -= dineroRetirar;

            return true;

        } else
            return false;

    }

    public double getOverdraftAmount()
    {
        return overdraftAmount;
    }

}
