
/**
 * Manage input to be read from either keyboard or file.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;

public class InputManager
{
    // Method: readOneAccountFrom
    // Precondition: inputSource is a Scanner object, already set up
    // to read from a text file or standard input source (keyboard).
    // Postcondition: returns an Account with the data read for its attributes.
    // Assumption: Account data will be in the format of: name,id,balance
    public static Account readOneAccountFrom (Scanner inputSource)
    {
        // Read one line of account data into oneLine
        System.out.println ("Reading: name,id,balance");
        String oneLine = inputSource.nextLine();
        
        // Parse line of account data, separated by commas.
        Scanner lineTokenizer = new Scanner (oneLine);
        lineTokenizer.useDelimiter (",");
        
        // Get account data (i.e. name, accountNum and balance) from oneLine
        String name = lineTokenizer.next ();
        long accountNum = lineTokenizer.nextLong ();
        double balance = lineTokenizer.nextDouble ();
        String id = "" + accountNum;
        String money = "" + balance;
        
        String[] splitMoney = money.split(".");
        
        Money userBalance = new Money (Integer.parseInt(splitMoney[0]), Integer.parseInt(splitMoney[1]));
       
      
        
        // Create and return an Account object with the data read for one   account.
        Account oneAccount = new Account (name, id, userBalance);
        System.out.println ("Account read: " + oneAccount);
        
        return oneAccount;
    } // end readOneAccountFrom
    
} // end InputManager
