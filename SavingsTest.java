

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SavingsTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class SavingsTest
{
    /**
     * Default constructor for test class SavingsTest
     */
    public SavingsTest()
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
    public void testAddInterest(){
        
        Account myCash = new Account ("Lyn","8",new Money(1000,00));
        Money interest = new Money(1060,00);
        Account myCashExpected = new Account("Lyn", "8", interest);
        
        Account myCash2 = new Account ("Akshat","88",new Money(1005,35));  
        Money interest2 = new Money(1065,30);
        Account myCashExpected2 = new Account("Akshat", "88", interest2);
        
        assertTrue ("Error in testAddInterest", myCash.equals(myCashExpected));
        assertTrue ("Error in testAddInterest", myCash2.equals(myCashExpected2));
    }
}
