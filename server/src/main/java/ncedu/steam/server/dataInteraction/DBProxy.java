package ncedu.steam.server.dataInteraction;

import java.util.LinkedList;
import java.util.List;

/**
 * DBProxy
 * User: aielemental
 * Date: 20.03.13
 * Time: 15:32
 */
//todo add description
public class DBProxy implements DataProvider {
    //todo to Sasha: I ask you to write this class
    public int getUserID(String login) {
        //stub
        return "test".equals(login) ? 0 : -1;
    }

    public int checkUser(String login, String password) {
        //stub
        if ("test".equals(login) && "password".equals(password)) {
            return 0;
        }
        return -1;
    }

    public List<Game> getGamesList(int userID) {
        List<Game> result = new LinkedList<Game>();
        result.add(new Game(0, "dummyGame", 10));
        return new LinkedList<Game>();
    }
}
