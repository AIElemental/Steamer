package ncedu.steam.server.clientInteraction;

import ncedu.steam.server.ClientListener;
import ncedu.steam.server.Server;
import ncedu.steam.server.dataInteraction.Game;
import ncedu.steam.server.dataInteraction.User;

import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * SimpleClientListener
 * User: aielemental
 * Date: 20.03.13
 * Time: 15:14
 */
//todo add description
public class SimpleClientListener implements ClientListener {

    public boolean checkAvailability(String newLogin) throws RemoteException {
        System.out.println("Client accessed checkAvailability");
        return server.getDataProvider().getUserID(newLogin) < 0;
    }

    public User logIn(String login, String password) throws RemoteException {
        System.out.println("Client accessed login");
        if ("test".equals(login) && "password".equals(password)) {
            return new User(0, login, 100);
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean logOut(int userID) throws RemoteException {
        System.out.println("Client accessed logout");
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<Game> getGamesList(int userID) throws RemoteException {
        System.out.println("Client accessed gamelist");
        return new LinkedList<Game>();
    }

    public SimpleClientListener(Server base) {
        server = base;
    }

    private Server server;
}
