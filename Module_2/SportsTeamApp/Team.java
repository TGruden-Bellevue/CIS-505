public class Team {
    private String teamName;
    private String[] players;
    private int playerCount;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new String[20]; // default size
        this.playerCount = 0;
    }

    public void addPlayer(String playerName) {
        if (playerCount < players.length) {
            players[playerCount] = playerName;
            playerCount++;
        } else {
            System.out.println("Maximum player limit reached for the team.");
        }
    }

    public String[] getPlayers() {
        return players;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public String getTeamName() {
        return teamName;
    }
}
