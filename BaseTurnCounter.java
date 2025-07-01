package baseGame;

import java.util.List;
import java.util.ArrayList;

public class BaseTurnCounter extends Thread {
    //This is a shared static list that holds all players participating in the game.
    static List<BasePlayer> players = new ArrayList<>();
    //This defines how many rounds or turns each player will get.
    private static final int maxTurns = 3;

    public static void turnCount(BasePlayer player, int round) {
        try {
            System.out.println("Turn " + round + " started for " + player.getName());
            for (int i = 1; i <= 5; i++) {
                System.out.println(player.getName() + " counting: " + i);
                Thread.sleep(1000);
            }
            System.out.println("Turn " + round + " ended for " + player.getName() + "\n");
        } catch (InterruptedException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    //This method runs the entire turn-based sequence for all players.
    public static void nextTurn() {
        for (int round = 1; round <= maxTurns; round++) {
            for (BasePlayer player : players) {
                turnCount(player, round);
            }
        }
        System.out.println("Game Over!");
    }
}
