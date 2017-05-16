/** 
 * A blueprint for Money objects...
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money
{
    // attributes = state variables
    public int totalCents;
    public int dollars, cents;

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given dollars and cents.
     *
     * @param theDollars the number of dollars
     * @param theCents   the number of cents
     */
    public Money(int theDollars, int theCents)
    {
        this.totalCents = theDollars * 100 + theCents;
        theDollars = dollars;
    }

    /**
     * Constructor: initializes all attributes (i.e. totalCents)
     * based on the given total cents.
     *
     * @param theCents  the total number of cents
     */
    public Money(int theCents)
    {
        this.totalCents = theCents;
    }

    public Money getBalance()
    {
        return new Money (this.totalCents);
    }

    /**
     * getDollars:
     *
     * @return the number of dollars
     */
    public int getDollars()
    {
        return (int) this.totalCents / 100;
    }

    /**
     * getCents:
     *
     * @return the number of cents (between 0 and 99, inclusive)
     */
    public int getCents()
    { 
        return (int) this.totalCents % 100;
    }

    public int getTotalCents(){
        return this.totalCents;
    }
    
    /**
     * add: adds two money values
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is added to the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     * 
     * @param a Money, the Money amount to add to the calling object (this)
     * @return Money, the sum
     */
    public Money add (Money theMoney)
    {
        return new Money (this.totalCents + theMoney.totalCents);
    }

    /**
     * subtract: subtracts two money values
     * 
     * Precondition: two Money amounts are created and valid
     * Postcondition: the amount in this Money object is subtracted to the Money amount given as parameter; the result is returned.
     * Neither the calling object nor the parameter are changed.
     * 
     * @param a Money, the Money amount to suubtract to the calling object (this)
     * @return Money, the subtraction
     */
    public Money subtract (Money theMoney)
    {
        return new Money (this.totalCents - theMoney.totalCents);
        //return new Money (theMoney.totalCents - this.totalCents);
    }

    /**
     * toString: return String representation of this Money object
     * Precondition: this Money object is valid
     *
     * @return a String representation of this object
     */
    @Override
    public String toString()
    {
        String result =  this.getDollars() + "."; 

        if (this.getCents() < 10) {
            result += "0";
        }

        result += this.getCents();
        return result;
    }

    /**
     * equals: compare the status of two money objects.
     * 
     * @param other  a Money object
     * @return true if calling object (this) is in the same state as the Money object received as a parameter, and false otherwise.
     */
    public boolean equals (Money other)
    {
        return (this.totalCents == other.totalCents);    
    }

    /**
     * compareTo compare the status of two money objects.
     * 
     * @param other  a Money object
     * @return (-1) if its less, (0) if its equal and (1) if its greater.
     */
    public int compareTo (Money other)
    {
        if(this.totalCents < other.totalCents)
            return -1;
        else if (this.totalCents == other.totalCents)
            return 0;
        else
            return 1;

    }
}
