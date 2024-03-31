/* Citations 

Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th
ed.). Pearson Education, Inc.
Modifications by R. Krasso, 2021

Payne, D., (2021). CSD 405 Intermediate Java Programming. Bellevue University, all
rights reserved

Java classes and objects. (n.d.-b). https://www.w3schools.com/java/java_classes.asp 


*/



public class Team {
    //Private fields to store team, player and number of players 
    private String teamName;
    private String[] players;
    private int playerCount;


    //Constructor to initialize a team object 
    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20]; // default size
        this.playerCount = 0;
    }

    //Add Players to the team 
    public void addPlayer(String playerName) {
        if (playerCount < players.length) {
            players[playerCount] = playerName;
            playerCount++;
        } else {
            System.out.println("Maximum player limit reached for the team.");
        }
    }
    // Get the array of players
    public String[] getPlayers() {
        return players;
    }
    //Get the number of players on the team 
    public int getPlayerCount() {
        return playerCount;
    }
    //Get the Team name 
    public String getTeamName() {
        return teamName;
    }
}
