
/**
 * Write a description of class savings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Savings extends Account 
{
    
    private double interestRate;

    /**
     * Constructor for objects of class savings
     */
    public Savings(String name, String id,  Money amount)
    {
        super(name, id,  amount);
        interestRate = 0.06;
    }

    /**
     * Adds interest method
     */
    public void addInterest(Account a){
        int temp = this.getBalance().getTotalCents(); //1000
        //Lose some cents in conversion :(
        int total =  (int)(temp * (interestRate + 1));//1000*(1.06)=1060

        Money newMoney = new Money(total);
        this.setBalance(newMoney);

    }
}
