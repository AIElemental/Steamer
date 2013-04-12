package ncedu.steam.server.dataInteraction;

import java.io.Serializable;

/**
 * User
 * User: aielemental
 * Date: 27.03.13
 * Time: 21:42
 */
//todo add description
public class User implements Serializable {
    public User(int ID, String login, int money) {
        this.ID = ID;
        this.login = login;
        this.money = money;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    private int ID;
    private String login;
    /**
     * password field is omitted for the sake of safety
     */
    private int money;
}
