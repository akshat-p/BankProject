import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

// Driver class for Bank project
public class ATM {
    public static void main (String[] args) {
        System.out.print("\f"); //Clear the screen 

        try {
            Bank myBank = readFromFile("in_accounts.txt"); // Read data from a file into a Bank

            dialogBox(myBank); //promps the dialog box that only prints the user's accoun info if the log in is correct

        } // end try    
        catch (IOException ioe) {
            System.out.println("IOException in main: " + ioe.getMessage()); 
            ioe.printStackTrace();
        } // end catch
        catch (Exception e) {
            System.out.println("Exception in main: " + e.getMessage());
            e.printStackTrace();
        } // end catch
    } // end main

    /**
     * readFromFile:    reads all accounts that are on the in_accounts text file
     * Precondition:    the text file is in the same folder as the bluej project
     * Postcondition:   myBank is returned with all the accounts added to it as account objects
     * @param           fileName: name of file that is read
     * @return          myBank: retuns the BankInterface with the accounts read added to it
     */
    public static Bank readFromFile (String fileName) throws IOException {
        Bank myBank = new Bank("Chase"); //Creates new bank
        String [] info = new String[3];
        String [] money = new String[2];
        String balance, currentLine;;
        int dollars, cents;

        // Open a file for reading.
        Scanner inputSource = new Scanner (new File(fileName));

        // while there are more tokens to read from the input source...
        while (inputSource.hasNextLine()) {
            currentLine = inputSource.nextLine(); // Read one line of input from the file into an Account object
            info = currentLine.split(" "); //adds each split part into the array

            balance = info[2];

            money[0] = balance.substring(0,balance.indexOf("."));
            money[1] = balance.substring(balance.indexOf(".") + 1);

            dollars = Integer.parseInt(money[0]);
            cents = Integer.parseInt(money[1]);

            Account acc = new Account(info[0], info[1], new Money(dollars,cents)); //Creates account objects
            myBank.addAccount(acc); // Store the account info in the bank
        } // end while

        return myBank;
    } // end readFromFile

    public static void menu(Bank b, String id) {
        Scanner s = new Scanner(System.in);
        String [] amount = new String[2];
        Account user = b.search(id);
        Checking check; 
        Money balance, mCents;
        String money;
        String account = user.toString();

        while(true) {
            System.out.print("--------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("\t\t\t\t\tATM");
            System.out.println("--------------------------------------------------------------------------------------------------------------------\n");
            System.out.println("Choose 1 for Withdraw");
            System.out.println("Choose 2 for Deposit");
            System.out.println("Choose 3 for Check Balance");
            System.out.println("Choose 4 for EXIT");
            System.out.print("\nChoose the operation you want to perform: ");

            int n = s.nextInt();

            switch(n) {
                case 1: //To withdraw Money

                System.out.print("Enter Amount to be withdrawn: ");
                money = "" + s.nextDouble();

                amount[0] = money.substring(0, money.indexOf("."));
                amount[1] = money.substring(money.indexOf(".") + 1);

                balance = new Money(Integer.parseInt(amount[0]), Integer.parseInt(amount[1]));
                check = new Checking (user.getName(), id, user.getBalance());
                //b.withdraw(id, balance);
                check.withdrawl(balance);
                account = check.toString();
                pause();
                //b.withdraw(id, balance);
                writer(user);

                System.out.println("\n$" + money + " successfully withdrawn.");
                pause();

                break;

                case 2: //To deposit money

                System.out.print("Enter amount to deposit: ");
                money = "" + s.nextDouble();

                amount[0] = money.substring(0, money.indexOf("."));
                amount[1] = money.substring(money.indexOf(".") + 1);

                balance = new Money(Integer.parseInt(amount[0]), Integer.parseInt(amount[1]));
                mCents = balance.getBalance();
                b.deposit(id, balance);
                writer(user);
                account = user.toString();

                System.out.println("$" + balance + " has been successfully deposited.\n");
                System.out.println();
                pause();
                break;

                case 3: //To check the balance

                System.out.println(account + "\n");
                pause();
                break;

                case 4:
                System.exit(0);
            }
        }
    }

    /**
     * Method dialogBox:    pops up a dialog box in which the user has to enter their account id for the account to be printed
     * Precondition:        bank has been created prior to the calling of this method
     * @param               bank: BankInterface created in the main method
     */
    public static void dialogBox(Bank bank){
        String id;
        boolean run = true; //True means the account has not been found

        do {
            id = JOptionPane.showInputDialog("Log in with your ID number: ");

            if(bank.search(id) != null) {
                Account user = bank.search(id);
                menu(bank, id);
                //System.out.println(user.toString()); //Prints the user's info
                run = false; //Account has been found, can stop showing the dialog box
            }
        } while (run);

    }

    public static void writer(Account user) {
        BufferedWriter bw = null;
        FileWriter fw = null;

        try {
            fw = new FileWriter("out_accounts.txt");
            bw = new BufferedWriter(fw);
            bw.write(user.toString());
            System.out.println("Done");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }
    }

    /**
     * Description: A simple pause for the menu so the sue can see the results before the screen is cleared.
     */
    public static void pause(){
        System.out.print("Press enter to continue...");
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        System.out.print("\f");
    }

} // end ATM
