import java.util.ArrayList;

public class Bank implements BankInterface
{

    // instance variables - replace the example below with your own
    private String nameOfBank;
    //private Account[] accounts;
    private ArrayList <Account> accounts;
    private int numOfAccounts;
    Comparable[] array;

    /**
     * Constructor: initializes all attributes (i.e. nameOfBank, account, numOfAccounts)
     * based on the given dollars and cents.
     *
     * @param name   name of the bank
     */
    public Bank(String name)
    {
        nameOfBank = name;
        accounts = new ArrayList<Account>();
        numOfAccounts = 0;
        array = new Comparable[1000];
    }

    public String getName() {
        return this.nameOfBank;
    }
    
    /**
     * Gets The Account at the given Index
     */

    public Account getAccounts(int index){
        return accounts.get(index);
    }

    /**
     * addAccount: Add a account to bank.
     * 
     * Precondition: To add Account you need to provide (name,id,amount)
     * Postcondition: The account is added to Array of Accounts.
     */
    public void addAccount(Account acc){
        if(search(acc.getID()) != acc) {
            accounts.add(numOfAccounts, acc);
            array[numOfAccounts] = acc;
            numOfAccounts++;
        } else{
            throw new AccountAlreadyExistsException ("Account already exist!");
        }

    }
    
    public void removeAccount(String id) {
        if(search(id) != null) 
            accounts.remove(search(id));
        else
            throw new AccountAlreadyExistsException ("Account doesnt exist!");
    }

    /**
     * Search: Search a particular account in bank.
     * Precondition: id is given by the user
     * Postcondition: The account is searched and returned.
     * 
     */
    public Account search(String id){

        for(int i=0; i<accounts.size(); i++){
            if(getAccounts(i).getID().equals(id)) {
                return accounts.get(i);
            }
        } 
        return null;        
    }

    public String searchInfo(String id) {
        Account user = null;
        for(int i=0; i<accounts.size(); i++){
            if(getAccounts(i).getID().equals(id)) {
                user = accounts.get(i);
            }
        }  
        String userAccount = "" + user.toString();
        return userAccount;
    }

    /**
     * Deposit: Deposit Money to a particular bank account.
     * 
     * Precondition: You need to provide id and the money amount you want to deposit
     * Postcondition: the amount in this Money object is added to the Money amount of a particular account.
     * 
     * @param a id, the id of account in bank
     * @param a Money, the Money amount to add to the calling object id.
     */
    public void deposit(String id, Money money){
        search(id).deposit(money);
    }

    /**
     * Withdraw: Withdraw Money to a particular bank account.
     * 
     * Precondition: You need to provide id and the money amount you want to Withdraw
     * Postcondition: the amount in this Money object is subtracted from the Money amount of a particular account.
     * 
     * @param a id, the id of account in bank
     * @param a Money, the Money amount to subtract to the calling object id.
     */
    public void withdraw(String id, Money money){
        search(id).withdrawl(money);
    }

    /**
     * Increases the size of Array of Account everytime you add a new Account.
     * 
     */
    private void increaseSize (){
        Account[] temp = new Account[accounts.size() * 2];

        for (int i = 0; i < accounts.size(); i++)
            temp[i] = this.getAccounts(i);
        //temp[i] = accounts[i];

        // accounts = temp;
    }

    /**
     * toString: converts the bank to a String value.
     * 
     * Precondition: no precondition
     * Postcondition: returns the string value of bank name and Array of Accounts.
     */
    public String toString()
    {
        String converted = this.nameOfBank + "\n" ;

        for(int i=0; i<numOfAccounts; i++){
            converted += accounts.get(i).toString() + "\n";
        }

        return converted;
    }

    public void sortAccounts() {
        SortsClass a = new SortsClass();
        
        for(int i=0; i<numOfAccounts; i++) {
            array[i] = accounts.get(i);
        }
        
        accounts = a.selectionSort(accounts, numOfAccounts);
    }
}