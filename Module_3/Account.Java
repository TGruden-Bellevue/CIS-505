/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/





// Account class
class Account {
    private double balance = 200; // Default balance

    // Accessor method for balance
    public double getBalance() {
        return balance;
    }

    // Deposit method
    public void deposit(double amt) {
        balance += amt;
    }

    // Withdraw method
    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
        }
    }

    // Display menu method
    public void displayMenu() {
        System.out.println("Account Menu");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Balance"); // Added option to check balance
        System.out.println("4. Exit");
    }

    // Get transaction date method
    public String getTransactionDate() {
        // Dummy implementation, replace with actual date logic
        return "MM-dd-yyyy";
    }
}
