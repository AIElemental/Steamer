package ncedu.steam.server;

import ncedu.steam.server.dataInteraction.Game;
import ncedu.steam.server.dataInteraction.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * ClientListener
 * User: aielemental
 * Date: 20.03.13
 * Time: 13:51
 */
//todo add description
public interface ClientListener extends Remote{
    /**
     * RMI name
     */
    public static final String NAME = "ClientListener";

    /**
     * Check if {@code newLogin} is already in use
     * @param newLogin new name to check
     * @return "true" if {@code newLogin} is not in use
     * @throws RemoteException
     */
    boolean checkAvailability(String newLogin) throws RemoteException;

    /**
     * Check login & password combination
     * @param login
     * @param password
     * @return true if login successful,
     * false if login does not exist or password is incorrect for this login
     * @throws RemoteException
     */
    User logIn(String login, String password) throws RemoteException;

    /**
     * Set this user status to offline
     * @param userID who to log out
     * @return true if logOut successful, false if any errors occur;
     * @throws RemoteException
     */
    boolean logOut(int userID) throws RemoteException;

    /**
     * Get list of games
     *
     * @param userID whose games to get
     * @return list of {@code Game} instances representing owned games
     * @throws RemoteException
     */
    List<Game> getGamesList(int userID) throws RemoteException;
}
