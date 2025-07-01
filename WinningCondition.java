package teenPatti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningCondition {


        public static boolean isSet(String[] cards) {
            String firstCardValue = cards[0].substring(0, cards[0].length() - 1);

            for (int i = 1; i < cards.length; i++) {
                String cardValue = Deck.getCardWithoutColour(cards[i]);
                if (!firstCardValue.equals(cardValue)) {
                    return false;
                }
            }
            return true;
        }



        public static boolean isColour(String[] cards){
            char firstCardIcon = cards[0].charAt(cards[0].length()-1);
            for (int i=0; i<= cards.length-1; i++){
                char cardIcon = Deck.getCardIcon(cards[i]);
                if (cardIcon != firstCardIcon){
                    return false;
                }
            }
            return true;
        }



        public static boolean isSequence(String[] cards) {
            List<Integer> cardWeight = new ArrayList<>();
            for (int i = 0; i < cards.length; i++) {
                int cardWeight1 = Deck.getCardWeight(cards[i]);
                cardWeight.add(cardWeight1);
            }
            Collections.sort(cardWeight);
            for (int j=1; j<cardWeight.size(); j++){
                if (cardWeight.get(j) != cardWeight.get(j-1)+1){
                    return false;
                }
            }
            return true;
        }

        public static boolean isPureSequence(String[] cards) {
            return  isSequence(cards) && isColour(cards);
        }



        public static boolean isPair(String[] cards){
            for (int i=0; i< cards.length; i++){

                String cardValue = Deck.getCardWithoutColour(cards[i]);
                for (int j=i+1; j< cards.length; j++){
                    String card2 = cards[j];
                    String compareCardValue =  card2.substring(0,card2.length()-1);
                    if (cardValue.equals(compareCardValue)){
                        return true;
                    }
                }
            }
            return false;
        }


        public static boolean isHighCard(String[] cards){
            return !isSet(cards) && !isColour(cards) && !isSequence(cards) && !isPureSequence(cards) && !isPair(cards);

        }

        public static int getPlayerCardsWeight(String[] cards){
            int handWeight = 0;

            if (isSet(cards)) {
                handWeight = 600;
            } else if (isPureSequence(cards)) {
                handWeight = 500;
            } else if (isSequence(cards)) {
                handWeight = 400;
            } else if (isColour(cards)) {
                handWeight = 300;
            } else if (isPair(cards)) {
                handWeight = 200;
            } else if (isHighCard(cards)) {
                handWeight = 100;
            }
            else {
                System.out.println("Player don't have any card!");
            }

            return  Deck.getCardsTotalWeight(cards) + handWeight;

        }

    }


