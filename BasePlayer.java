package baseGame;

import java.util.ArrayList;
import java.util.List;

public class BasePlayer {
    private String name;
    private long id;
    public long Balance;
    private String[] cards;

    public String[] getCards() {
        return cards;
    }

    public void setCards(String[] cards) {
        this.cards = cards;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public long getId() {
//        return id;
//    }
    public int getId() {
        return this.hashCode(); // Or implement some specific ID logic
    }

    public void setId(long id) {
        this.id = id;
    }
}
