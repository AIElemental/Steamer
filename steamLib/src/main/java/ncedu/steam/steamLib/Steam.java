package ncedu.steam.steamLib;

import ncedu.steam.client.SteamLibListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Steam
 * User: aielemental
 * Date: 20.03.13
 * Time: 13:21
 */
//todo add description
public class Steam {
    public static boolean checkOwnage(String gameTitle) {
        try {
            Registry registry = LocateRegistry.getRegistry(null, 40002);
            SteamLibListener client = (SteamLibListener)registry.lookup(SteamLibListener.NAME);
            System.out.println("Connect to steam client");
            boolean ownageRequestResult = client.checkOwnage(gameTitle);
            System.out.println("Ask for ownage check = " + ownageRequestResult);
            return ownageRequestResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}
