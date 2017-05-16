import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CheckingTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CheckingTest
{
    /**
     * Default constructor for test class CheckingTest
     */
    public CheckingTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testWithdrawl(){
        Account myCash = new Account ("Lyn","8",new Money(1000,00));
        Account expected = new Account ("Lyn","8",new Money(1000,00));        
        Money deniedWithdraw = new Money(1601,00);

        Account myCash2 = new Account ("Akshat","8",new Money(1000,00));
        Account expected2= new Account ("Akshat","8",new Money(-92, 40));

        Money acceptedWithdraw = new Money(-92, 40);        

        myCash.withdrawl(deniedWithdraw);
        myCash2.withdrawl(acceptedWithdraw);

        assertTrue ("Error in testWithdrawl", myCash.equals(expected));
        assertTrue ("Error in testWithdrawl", myCash2.equals(expected2));
    }

    @Test
    public void testOverwithdraw() {
        // Create a checking account.
        Checking acc = new Checking("Akshat", "227" , new Money (222,01));

        try {
            // Withdraw an amount that should cause an exception of type InsufficientFundsException...
            acc.withdrawl( new Money(376, 0) );

            // If we reach this point in the code, that means the exception was not thrown as expected, so this test case fails.
            fail(); 
        }
        catch (InsufficientFundsException ife) {
            System.out.println("InsufficientFunds Exception on testOverwithdraw");
            ife.printStackTrace();
        }

    }
}