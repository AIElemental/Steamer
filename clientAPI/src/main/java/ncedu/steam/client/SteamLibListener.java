package ncedu.steam.client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * SteamLibListener
 * User: aielemental
 * Date: 29.03.13
 * Time: 14:07
 */
//todo add descriptionpackage ncedu.steam.client;
public interface SteamLibListener extends Remote {
    public static final String NAME = "SteamLibListener";

    boolean checkOwnage(String title) throws RemoteException;
}
