package baseGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

 public abstract class BaseGameManager {
    public   static List<BasePlayer> players = new ArrayList<>();

    public  void initializePlayer() {
        Scanner sc = new Scanner(System.in);
          // Ask the user for the number of players
        System.out.println("Enter Number Of Players ");
        int numberOfPlayers = sc.nextInt();
        sc.nextLine();

        // Loop to input details for each player
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter name of player " + (i + 1) + ": ");
            String playerName = sc.nextLine();


            // Create a new BaseGame.BasePlayer object and set name and ID
            BasePlayer basePlayer = new BasePlayer();
            basePlayer.setName(playerName);


            players.add(basePlayer); // Store in local list ,Add the player to the local list (in BaseGame.BaseGameManager)
            BaseTurnCounter.players.add(basePlayer); // Also add the player to the turn management list (in BaseGame.BaseTurnCounter)
        }
    }
    // Method to display player info (ID and Name)
    public  void playerInfo() {
        System.out.println("\n--- Player Info ---");
        for (BasePlayer player : players) {
            System.out.print("Player ID: " + player.getId() + ", Player Name: " + player.getName());

        }
    }


     public abstract void startGame();
     public abstract void showWinner();
}
