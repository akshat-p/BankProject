
/**
 * Write a description of interface BankInterface here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface BankInterface
{
    /**
     * Gets The Account at the given Index
     */

    public Account getAccounts(int index);

    /**
     * addAccount: Add a account to bank.
     * 
     * Precondition: To add Account you need to provide (name,id,amount)
     * Postcondition: The account is added to Array of Accounts.
     */
    public abstract void addAccount(Account acc);

    /**
     * Search: Search a particular account in bank.
     * Precondition: id is given by the user
     * Postcondition: The account is searched and returned.
     * 
     */
    public Account search(String id);

    /**
     * Deposit: Deposit Money to a particular bank account.
     * 
     * Precondition: You need to provide id and the money amount you want to deposit
     * Postcondition: the amount in this Money object is added to the Money amount of a particular account.
     * 
     * @param a id, the id of account in bank
     * @param a Money, the Money amount to add to the calling object id.
     */
    public abstract void deposit(String id, Money money);

    /**
     * Withdraw: Withdraw Money to a particular bank account.
     * 
     * Precondition: You need to provide id and the money amount you want to Withdraw
     * Postcondition: the amount in this Money object is subtracted from the Money amount of a particular account.
     * 
     * @param a id, the id of account in bank
     * @param a Money, the Money amount to subtract to the calling object id.
     */
    public abstract void withdraw(String id, Money money);

    /**
     * toString: converts the bank to a String value.
     * 
     * Precondition: no precondition
     * Postcondition: returns the string value of bank name and Array of Accounts.
     */
    public String toString();

}
