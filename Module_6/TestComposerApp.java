/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/

*/



import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    public static void main(String[] args) {
        MemComposerDao composerDao = new MemComposerDao();
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("Menu Options:");
            System.out.println("1. View Composers");
            System.out.println("2. Find Composer");
            System.out.println("3. Add Composer");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            option = scanner.nextInt();

            switch (option) {
                //Display Composers
                case 1:
                    System.out.println("\nPlease Choose an Option:\n");
                    System.out.println("--Displaying Composers--");
                    List<Composer> allComposers = composerDao.findAll();
                    for (Composer composer : allComposers) {
                        System.out.println(composer);
                        System.out.println();
                    }
                    System.out.println(); // Empty line
                    break;
                case 2:
                //Find By ID 
                    System.out.print("Enter an ID: ");
                    int id = scanner.nextInt();
                    Composer foundComposer = composerDao.findBy(id);
                    if (foundComposer != null) {
                        System.out.println("\n--Displaying Composer--\n");
                        System.out.println(foundComposer);
                    } else {
                        System.out.println("Composer not found!");
                    }
                    System.out.println(); // Empty line
                    break;
                case 3:
                //Add new Composers 
                    System.out.println("\nPlease Choose an Option:\n");
                    System.out.print("Enter an ID: ");
                    int newId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter a Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter a Genre: ");
                    String newGenre = scanner.nextLine();
                    Composer newComposer = new Composer(newId, newName, newGenre);
                    composerDao.insert(newComposer);
                    System.out.println("New composer added successfully!");
                    System.out.println(); // Empty line
                    break;
                case 4:
                //Exit 
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option! Please enter a valid option.");
                    break;
            }
        } while (option != 4);

        scanner.close();
    }
}
