package ejer1_20;

/**
 *
 * @author A15001169
 */
public class SavingsAccount extends Account
{

    private double interestRate;

    public SavingsAccount(double balance, double interestRate)
    {
        super(balance);

        this.interestRate = interestRate;

    }

    public void interestGenerate()
    {

        balance += (balance * interestRate);
    }

}
