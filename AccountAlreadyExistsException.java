
/**
 * Write a description of class InsufficientFundsException here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AccountAlreadyExistsException extends RuntimeException
{
    public AccountAlreadyExistsException(String s){
         super(s);
    }
}