------------------------------------------------------------------------
Design and implement an ADT representing a bank. The data of the ADT 
should include a collection (which could be an array or ListInterface or 
Vector or preferably an ArrayList) of Account. You may reuse the ADT 
Account you implemented for lab. Add to your ADT Account a 
compareTo(Account acc) method for comparing two Account objects, based 
on their account numbers. For the ADT Bank, include operations for 
adding a new account (account numbers must be unique; no duplicates 
allowed), removing an account (given the account number), sorting (you 
may use one of the following: selection sort, insertion sort, mergesort, 
or quicksort; see SortsClass.java ), searching for the account 
information (name and balance) associated with a given account number, 
depositing an amount to a given account, and withdrawing an amount from 
a given account; when implementing these operations, reuse when possible 
the methods of the ADT Account.

Design and implement a bank ATM driver class with methods for each of the 
following (use additional helper classes and methods as needed):
1. Read account information into a Bank object from a file: 
in_accounts.txt . Each line of the input file has info for one account, 
i.e. id, name, balance.
2. Ask the user to login by entering id, using a dialog box or standard input. 
3.Validate id.
4. Ask the user to enter a transaction (check balance / deposit / withdraw) 
using a dialog box or standard input. 
5. Validate the transaction. 
6. Execute the transaction.
7. When the user is done, write all account information (one line per 
account) in sorted ascending order of account ids, to an output file 
out_accounts.txt (see example of writing text to a file (which uses predefine
d classes in the java.io package: PrintWriter and FileWriter, so import 
java.io.PrintWriter; import java.io.FileWriter;), taken from examples of 
Dialog Boxes and File I/O).
------------------------------------------------------------------------

PROJECT TITLE: ATM
PURPOSE OF PROJECT: An ATM that represents a bank with accounts and like functions
VERSION or DATE: 16 May 2017
HOW TO START THIS PROJECT: Run the main method of the ATM class
AUTHORS: Lynoska Garcia nd Akshat Patel
NOTES: The output file only gets edited once a change in the account has been made 
