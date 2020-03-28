package ejer1_20;

/**
 *
 * @author A15001169
 */
public class SavingsAccount extends Account
{

    private final double interestRate;

    public SavingsAccount(double balance, double interestRate)
    {
        super(balance);
        this.interestRate = interestRate;
    }

    public void interestGenerate()
    {
        setBalance(getBalance() + (getBalance() * interestRate));
    }

    public double getInterestRate()
    {
        return interestRate;
    }

}
