package ncedu.steam.server.dataInteraction;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

/**
 * DataProvider
 * User: aielemental
 * Date: 20.03.13
 * Time: 15:34
 */
//todo add descriptionpackage ncedu.steam.server.dataInteraction;
public interface DataProvider {
    int getUserID(String login);
    int checkUser(String login, String password);
    List<Game> getGamesList(int userID);
}
