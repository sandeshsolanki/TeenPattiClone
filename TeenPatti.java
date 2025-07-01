package teenPatti;
import baseGame.BaseGameManager;
import baseGame.BasePlayer;
import baseGame.BaseTurnCounter;

import java.util.List;

public class TeenPatti extends BaseGameManager {

       @Override
       public  void startGame(){
            System.out.println("Welcome to teen patti");
        }

    @Override
    public void showWinner() {
        if (players == null || players.isEmpty()) {
            System.out.println("No players in the game.");
            return;
        }

        BasePlayer winner = null;
        int highestWeight = 0;

        for (BasePlayer player : players) {
            String[] cards = player.getCards(); // assumes getCards() returns player's hand
            int playerWeight = WinningCondition.getPlayerCardsWeight(cards);
            System.out.println(player.getName() + " has hand weight: " + playerWeight);

            if (winner == null || playerWeight > highestWeight) {
                winner = player;
                highestWeight = playerWeight;
            }
        }

        if (winner != null) {
            System.out.println("🏆 Winner is: " + winner.getName() + " with weight: " + highestWeight);
        } else {
            System.out.println("No winner could be determined.");
        }
    }


    public void initializePlayer(){
        Deck.suffleDeck();
         super.initializePlayer();

        for (BasePlayer player : players) {
            List<String> cardList = Deck.getCards(3);
            player.setCards(cardList.toArray(new String[0]));
        }

     }

    public void playerInfo() {
        System.out.println("\n--- Player Info ---");

        for (BasePlayer player : players) {
            System.out.print("Player ID: " + player.getId() + ", Player Name: " + player.getName() + ", Cards: ");

            String[] cards = player.getCards();
            if (cards != null && cards.length > 0) {
                for (String card : cards) {
                    System.out.print(card + " ");
                }
            } else {
                System.out.print("No cards assigned!");
            }

            System.out.println(); // New line for next player
        }
    }


    public static void main(String[] args) {
             TeenPatti game = new TeenPatti();
             game.startGame();
             game.initializePlayer();
             game.playerInfo();
             BaseTurnCounter.nextTurn();
             game.showWinner();
        }
    }

