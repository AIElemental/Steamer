package ncedu.steam.server.dataInteraction;

/**
 * Ownage
 * User: aielemental
 * Date: 27.03.13
 * Time: 21:43
 */
//todo add description
public class Ownage {
    public int getGameID() {
        return GameID;
    }

    public void setGameID(int gameID) {
        GameID = gameID;
    }

    private int userID;

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private int GameID;
}
