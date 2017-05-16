import java.util.Scanner;
import java.util.ArrayList;

public class Account implements Comparable
{
    private String name;
    private String id; 
    private Money balance;   
    private Checking c;
    /**
     * Constructor: initializes all attributes (i.e. name, id, amount)
     * based on the given dollars and cents.
     *
     * @param name      The name of the user
     * @param id        The ID of the user
     * @param amount    The account's balance
     */
    public Account(String name, String id,  Money amount){
        this.name = name;
        this.id = id;
        this.balance = amount;
    }

    public String getName(){
        return this.name;
    }
    //compareTo: compare two Account objects.
    //Precondition: parameter o is an Object (of type Account)
    //Postcondition: return 0 if this.id is the same as o.id, -1 if this.id < o.id, 1 if this.id > o.id.
    @Override 
    public int compareTo(Object o)
    {
        if(this.id.equals(o))
            return 0;
        else if (this.id.compareTo(o.toString()) == 1)
            return 1;
        else
            return -1;
    }

    public Money getBalance(){
        return this.balance;
    }

    public void setBalance(Money m) {
        this.balance = m;
    }

    public String getID(){
        return this.id;
    }

    /**
     * transfer: transfers money from one user to another
     * 
     * Precondition: user01 and amt are given by the user
     * Postcondition: the value of amt is added to the secondary user's account and subtracted from the primary user's account.
     * 
     * @param user01: the user who's account is being withdrawled from
     * @param amt: amount that is being transfered
     */
    public void transfer(Account user01, Money amt){
        balance.add(amt);
        user01.balance.subtract(amt);
    }

    public void withdrawl (Money money){
        //c.withdrawl(money);
        if(this.balance.compareTo(money) >= 0) {
            setBalance(balance.subtract(money));
        }
    }

    public void deposit (Money money){
        if(this.balance.compareTo(money) == 1)
            setBalance(balance.add(money));

    }

    /**
     * toString: converts the balance to a String value with the $ and accurate amount
     * 
     * Precondition: no precondition
     * Postcondition: returns the string value of the user's current amount with proper signs
     */
    public String toString()
    {
        String result = this.name + " " + this.id + " $" + this.balance.toString(); 

        if (balance.getCents() < 10) {
            result += "0";
        }

        return result;
    }

    public boolean equals (Account other)
    {
        return (balance.totalCents == balance.totalCents);    
    }

}