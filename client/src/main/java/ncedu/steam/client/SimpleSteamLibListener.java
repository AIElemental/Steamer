package ncedu.steam.client;

import ncedu.steam.server.dataInteraction.Game;

import java.rmi.RemoteException;

/**
 * SimpleSteamLibListener
 * User: aielemental
 * Date: 29.03.13
 * Time: 14:30
 */
//todo add description
public class SimpleSteamLibListener implements SteamLibListener{ 
    public boolean checkOwnage(String title) {
        System.out.println("Ownage check detected");
        if (client.getGames() != null) {
            for (Game game : client.getGames()) {
                if (game.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }
    public SimpleSteamLibListener(Client base) {
        client = base;
    }
    private Client client;
}
