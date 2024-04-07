/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/

// Main class to test the functionality
// TheTestBowlingShopAppClass.java
import java.util.Scanner;

public class TheTestBowlingShopAppClass {
    public static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("B. Get Bowling Balls");
        System.out.println("S. Get Bowling Shoes");
        System.out.println("A. Get Bowling Bags");
        System.out.println("X. Exit");
    }

    public static String getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextLine().toUpperCase();
    }

    public static boolean isValidChoice(String choice) {
        return choice.equals("B") || choice.equals("S") || choice.equals("A") || choice.equals("X");
    }

    public static void processUserChoice(String choice) {
        if (choice.equals("X")) {
            System.out.println("Exiting...");
            return;
        }

        TheGenericQueueClass<ProductClass> products = TheProductDBClass.getProducts(choice.toLowerCase());

        if (products.size() == 0) {
            System.out.println("No products available for the selected category.");
        } else {
            System.out.println("Select " + choice);
            System.out.println("---- Product list ---");
            while (products.size() > 0) {
                System.out.println(products.dequeue());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            String choice = getUserChoice(scanner);

            if (!isValidChoice(choice)) {
                System.out.println("Invalid choice. Please select a valid option.");
                continue;
            }

            processUserChoice(choice);

            if (choice.equals("X")) {
                break;
            }
        }

        scanner.close();
    }
}
