
/**
 * Write a description of class Checking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Checking extends Account
{
    // instance variables - replace the example below with your own
    private Money overdraftMaximum;

    /**
     * Constructor for objects of class Checking
     */
    public Checking(String name, String id,  Money amount)
    {
        super(name, id, amount);
        overdraftMaximum = new Money(150,00);
    }

     /**
     * Withdraw: withdraw money from the user
     * 
     * Precondition: The amount of money to be withdrawn 
     * Postcondition: The value is subtracted if it is less than overdraft maximum.
     * 
     * @param money
     */
    public void withdrawl(Money money) {
        if(money.compareTo(getBalance().add(overdraftMaximum)) > 0) {
            throw new InsufficientFundsException ( "Withdraw too much money: " + money);
        } else {
            //withdrawl(money);
            setBalance(getBalance().subtract(money));
        }
    }
    
    public Money getOverdraftMaximum(){
        return overdraftMaximum;
    }
}
