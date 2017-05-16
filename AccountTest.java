import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AccountTest
{
    private Account _amount;
    
    public Money _emp;
    
       public AccountTest()
    {
        //System.out.println("JUnit Framework calls Constructor of test class before executing test methods");
    }
    
     /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {
        _amount = new Account("aa", "123",new Money(0,0)); 
        Money balance = new Money(305, 23);
        Account user = new Account ("Lyn", "133", balance);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {
        _amount = null;
    }
    
    @Test
    public void testToString()
    {
        // First test: cents is two digits
        Account amount = new Account ("Akshat ","7 ",new Money(7,55));
        System.out.println(amount);
        String actual = amount.toString();
        String expected = "Akshat 7 $7.55";
        assertFalse("Error in testToString", actual.equals(expected));
        
        // Second test: cents is one digit
        Account amount2 = new Account ("Lyn","8",new Money(7,05));
        String actual2 = amount2.toString();
        String expected2 = "Lyn 8 $7.05";
        assertFalse("Error in testToString", actual2.equals(expected2));
    }
    
        // Test equality of money values that are the same.
    @Test
    public void testEquality()
    {
        Account myCash = new Account ("Lyn","8",new Money(3, 75));
        Account yourCash = new Account ("Akshat","7",new Money(3, 75));
        
        assertTrue ("Error in testEquality", myCash.equals(yourCash));
        
        Account myAmount = new Account ("Lyn","8",new Money(50,0));
        Account yourAmount = new Account ("Akshat","7",new Money(50,0));
        
        assertTrue ("Error in testEquality", myAmount.equals(yourAmount));
    }
    
    // Test inequality of money values that are different.
    @Test
    public void testInequality()
    {
        Account myCash = new Account ("Lyn","8",new Money(3, 75));
        Account difftDollarsSameCents = new Account ("Lyn","8",new Money(4, 75));    
        Account difftDollarsDifftCents = new Account ("Lyn","8",new Money(4, 80));   
        Account sameDollarsDifftCents = new Account ("Lyn","8",new Money(3,80));   
        
        assertTrue ("Error in testInequality", myCash.equals(difftDollarsSameCents));
        assertTrue ("Error in testInequality", myCash.equals(difftDollarsDifftCents));
        assertTrue ("Error in testInequality", myCash.equals(sameDollarsDifftCents));
    }
    
    @Test
    public void testTransfer(){
        Money balance1 = new Money(100, 63);
        Account user1 = new Account("Lyn", "12345", balance1);
        
        Money balance2 = new Money(10, 73);
        Account user2 = new Account("Akshat", "678900", balance2);
        
        Money exchange = new Money(50, 64);
        
        user1.transfer(user2, exchange);
        
    }
        
    @Test
    public void testWithdrawl(){
        Money balance = new Money(150, 20);
        Account user = new Account("Lyn", "12345", balance);
        
        Money moneyWithdrawn = new Money(100, 10);
        
        Money expectedBalance = new Money(50, 10);
        Account expected = new Account ("Lyn", "12345", expectedBalance);
        user.withdrawl(moneyWithdrawn);
        
        assertTrue ("Error in testWithdrawl", user.equals(expected));
    }
    
    @Test
    public void testDeposit(){
        Money balance = new Money(150, 20);
        Account user = new Account("Lyn", "12345", balance);
        
        Money moneyDeposit = new Money(100, 10);
        
        Money expectedBalance = new Money(250, 30);
        Account expected = new Account ("Lyn", "12345", expectedBalance);
        user.deposit(moneyDeposit);
        
        assertTrue ("Error in testDeposit", user.equals(expected));
    }
    
}
    