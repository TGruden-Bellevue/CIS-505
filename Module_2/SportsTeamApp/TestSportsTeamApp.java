/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/java/java_classes.asp 

*/


import java.util.Scanner;

public class TestSportsTeamApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Starts a loop and enter a team name 
        while (true) {
            System.out.print("Enter team name: ");
            String teamName = scanner.nextLine(); 

            //Enter a Players Name 
            System.out.print("Enter player names (separated by commas without spaces): ");
            String playerNamesInput = scanner.nextLine();
            String[] playerNames = playerNamesInput.split(",");

            // Adding players to the team 
            Team team = new Team(teamName);
            for (String playerName : playerNames) {
                team.addPlayer(playerName);
            }

            // Display the entered number of players 
            System.out.println("Number of players in team " + team.getPlayerCount());
            
            //Display the list of players on the Team 
            System.out.print("Players on team: ");
            for (int i = 0; i < team.getPlayerCount(); i++) {
                System.out.print(team.getPlayers()[i]);
                if (i < team.getPlayerCount() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();

            // User enters if they would like to continue
            System.out.print("Do you want to continue (yes/no)? ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}
