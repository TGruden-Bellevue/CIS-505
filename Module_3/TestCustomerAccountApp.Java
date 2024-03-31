/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/


import java.util.Scanner;

// TestCustomerAccountApp class
public class TestCustomerAccountApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Prompt user to enter customer number
        System.out.print("Enter customer number (1007-1009): ");
        int customerId = scanner.nextInt();
        Customer customer = CustomerDB.getCustomer(customerId);

        // Step 2: Display account menu
        Account account = new Account();

        int choice;
        do {
            account.displayMenu(); // Display the menu

            // Handle user selection
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Account Balance: $" + account.getBalance());
                    System.out.println(); // Print an empty line for spacing
                    break;
                case 4:
                    System.out.println("Exiting menu...");
                    break;
                default:
                    System.out.println("Error: Invalid Option.");
                    break;
            }
        } while (choice != 4);

        // Step 5: Display customer details and account balance
        System.out.println(customer);
        System.out.println("Final Account Balance: $" + account.getBalance());

        scanner.close();
    }
}
