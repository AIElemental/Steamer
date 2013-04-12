package ncedu.steam.client;

import ncedu.steam.server.ClientListener;
import ncedu.steam.server.dataInteraction.Game;
import ncedu.steam.server.dataInteraction.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;

/**
 * Client
 * User: aielemental
 * Date: 29.03.13
 * Time: 14:33
 */
//todo add description
public class Client {
    public static final int STEAM_LIB_LISTENER_PORT = 40002;
    public void run() {
        System.out.println("Client initialized");
        //--------simulate work-------------------
        try {
            Registry registry = LocateRegistry.getRegistry(null, 40001);
            ClientListener server = (ClientListener)registry.lookup(ClientListener.NAME);
            System.out.println("Logging in");
            user = server.logIn("test", "password");
            System.out.println("Login = " + user);
            if (user != null) {
                System.out.println("Getting games list");
                games = server.getGamesList(user.getID());
                Iterator<Game> iterator = games.iterator();
                while (iterator.hasNext()) {
                    Game game = iterator.next();
                    System.out.print(game + (iterator.hasNext() ? ", " : "."));
                }
                System.out.println("Logging out");
                boolean logoutResult = server.logOut(user.getID());
                System.out.println("Logout " + (logoutResult ? "" : "un") + "successful");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //END SIMULATE
        try {
            SteamLibListener stub = (SteamLibListener) UnicastRemoteObject.exportObject(steamLibListener, 0);
            Registry registry = LocateRegistry.createRegistry(STEAM_LIB_LISTENER_PORT);
            registry.bind(SteamLibListener.NAME, stub);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Client RMI initialized");
        while (true) {
            //System.out.println("Listening to steamLib calls");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    public List<Game> getGames() {
        return games;
    }

    public boolean isOnline() {
        return online;
    }

    public User getUser() {
        return user;
    }

    private User user = null;
    private List<Game> games = null;
    private SteamLibListener steamLibListener = new SimpleSteamLibListener(this);
    private boolean online = false;
}
