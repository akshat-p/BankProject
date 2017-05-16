import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class testBank.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testBank{
    private Bank _bank;

    /**
     * Default constructor for test class testBank
     */
    public testBank()
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
        _bank = new Bank("Chase");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        _bank = null;
    }

    //Test addAccount()
    @Test
    public void testAddAccount(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Bank bank = new Bank("Chase");

        Money balance2 = new Money(1520, 45);
        Account user2 = new Account("Akshat", "12345", balance);
        Bank bank2 = new Bank("Chase");

        bank.addAccount(user);
        bank.addAccount(user2);
        assertTrue("Error in testAddAccount", bank.getAccounts(0).equals(user));
    }

    //Test search()
    @Test
    public void testSearch(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Bank bank = new Bank("Chase");
        
        bank.addAccount(user);
        
        Account actual = bank.search("12345");

        assertTrue ("Error in testSearch", actual.equals(user));
    }

    //Test search()
    @Test
    public void testSearchInfo(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Account user2 = new Account("Lyn", "125", balance);
        Bank bank = new Bank("Chase");
        
        bank.addAccount(user);
        bank.addAccount(user2);
        
        String actual = bank.searchInfo("12345");
        System.out.print(actual);
        String expected = "Akshat 12345 $1520.45";

        assertTrue ("Error in testSearchInfo", actual.equals(expected));
    }
    
    
    //Tests deposit()
    @Test
    public void testDeposit(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Bank bank = new Bank("Chase");

        bank.addAccount(user);

        Money addedMoney = new Money(120, 01);
        bank.deposit("12345", addedMoney);

        Money balanceExpected = new Money(1640, 46);
        Account userExpected = new Account("Akshat", "12345", balanceExpected);

        assertTrue ("Error in testDeposit", user.equals(userExpected));        
    }

    //Tests withdraw()
    @Test
    public void testWithdraw(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Bank bank = new Bank("Chase");

        bank.addAccount(user);

        Money subtractedMoney = new Money(120, 01);
        bank.withdraw("12345", subtractedMoney);

        Money balanceExpected = new Money(1400, 44);
        Account userExpected = new Account("Akshat", "12345", balanceExpected);

        assertTrue ("Error in testDeposit", user.equals(userExpected));        
    }

    //Test toString()
    @Test
    public void testToString(){
        Money balance = new Money(1520, 45);
        Account user = new Account("Akshat", "12345", balance);
        Bank bank = new Bank("Chase");

        bank.addAccount(user);

        String converted = bank.toString();
        String expected = "Chase\nAkshat 12345 $1520.45\n";//Lyn 56478 $500.45\n";
        assertTrue ("Error in testString", converted.equals(expected));        
    }
    
    //Test testSortAccounts
    @Test
    public void testSortAccounts(){
        Comparable [] array = new Comparable[1000];
        Bank bank = new Bank("Chase");
        Bank bank2 = new Bank("Chase");
        
        Account one = new Account("Lyn", "123", new Money (1005,59));
        Account two = new Account("Akshat", "1235", new Money (12,19));
        Account three = new Account("Lynshat", "023", new Money (102,51));
        Account four = new Account("Hooray", "1555", new Money (265,59));
        Account five = new Account("Hray", "1556", new Money (275,59));
        
        bank.addAccount(one);
        bank.addAccount(two);
        bank.addAccount(three);
        bank.addAccount(four);
        bank.addAccount(five);

        bank.sortAccounts();

        String actual = bank.toString();
        System.out.println(actual);
        String expected = "Chase\nLynshat 023 $102.51\nLyn 123 $1005.59\nAkshat 1235 $12.19\nHooray 1555 $265.59\nHray 1556 $275.59\n";
       
        assertTrue ("Error in testSortAccounts", actual.equals(expected));
    }
}
