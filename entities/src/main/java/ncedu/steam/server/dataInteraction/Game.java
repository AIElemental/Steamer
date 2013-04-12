package ncedu.steam.server.dataInteraction;

import java.io.Serializable;

/**
 * Game
 * User: aielemental
 * Date: 27.03.13
 * Time: 21:42
 */
//todo add description
public class Game implements Serializable {
    public Game(int ID, String title, int cost) {
        this.cost = cost;
        this.ID = ID;
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private int ID;
    private int cost;
    private String title;
}
