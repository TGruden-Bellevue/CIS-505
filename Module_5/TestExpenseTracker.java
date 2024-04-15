
/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean continueLoop = true;
        while (continueLoop) {
            // Display menu options
            System.out.println("Menu Options");
            System.out.println("1. View Transactions");
            System.out.println("2. Transactions");
            System.out.println("3. View Expense");

            // Get user input
            int option = ValidatorIO.getInt(input, "Please choose an option: ");

            // Perform actions based on user input
            switch (option) {
                case 1:
                ArrayList<Transaction> transactions = null;
                try {
                    transactions = TransactionIO.findAll();
                    System.out.println("Please Choose an Option:1");
                    System.out.println("MONTHLY EXPENSES\n");
                    for (Transaction transaction : transactions) {
                        System.out.println("Date: " + transaction.getDate());
                        System.out.println("Description: " + transaction.getDescription());
                        System.out.println("Amount: $" + transaction.getAmount() + "\n");
                    }
                } catch (IOException e) {
                    System.out.println("Error: Unable to read transactions from file.");
                }
                System.out.print("Continue? (y/n): ");
                char choice = input.next().charAt(0);
                continueLoop = (choice == 'y' || choice == 'Y');
                break;
                case 2:
                System.out.println("Option 2: Add Transactions");
                System.out.println("Enter transaction details:");
                System.out.print("Date (MM-dd-yyyy): ");
                String date = ValidatorIO.getString(input, "");
                System.out.print("Description: ");
                String description = ValidatorIO.getString(input, "");
                System.out.print("Amount: $");
                double amount = ValidatorIO.getDouble(input, "");
                
                // Create a new Transaction object with the inputted details
                Transaction newTransaction = new Transaction(date, description, amount);
                
                // Add the new transaction to the list
                ArrayList<Transaction> transactionList = new ArrayList<>();
                transactionList.add(newTransaction);
                
                // Save the transaction to file
                try {
                    TransactionIO.bulkInsert(transactionList);
                    System.out.println("Transaction added successfully.");
                } catch (IOException e) {
                    System.out.println("Error: Unable to add transaction.");
                }
            
                // Prompt user to continue
                System.out.print("Continue? (y/n): ");
                char choice = input.next().charAt(0);
                continueLoop = (choice == 'y' || choice == 'Y');
                break;
                case 3:
                System.out.println("Option 3: View Expense");
                double totalExpense = 0;
                ArrayList<Transaction> transactionsList = null;
                try {
                    transactionsList = TransactionIO.findAll();
                    for (Transaction transaction : transactionsList) {
                        totalExpense += transaction.getAmount();
                    }
                    System.out.println("Your total monthly expense: $" + totalExpense);
                } catch (IOException e) {
                    System.out.println("Error: Unable to read transactions from file.");
                }
                break;
            }

            // Ask user if they want to continue
            char choice = ValidatorIO.getChar(input, "Continue? (y/n): ");
            continueLoop = (choice == 'y' || choice == 'Y');
        }

        // No need for return statement in main method
    }
}
