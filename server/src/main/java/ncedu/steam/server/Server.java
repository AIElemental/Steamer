package ncedu.steam.server;

import ncedu.steam.server.clientInteraction.SimpleClientListener;
import ncedu.steam.server.dataInteraction.DBProxy;
import ncedu.steam.server.dataInteraction.DataProvider;
import ncedu.steam.server.dataInteraction.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Server
 * User: aielemental
 * Date: 29.03.13
 * Time: 14:56
 */
//todo add description
public class Server {
    public static final int CLIENT_LISTENER_PORT = 40001;

    public void run() {
        System.out.println("Initializing");
        System.out.println("DB initialized");
        {
            try {
                ClientListener stub = (ClientListener) UnicastRemoteObject.exportObject(clientListener, 0);
                Registry registry = LocateRegistry.createRegistry(CLIENT_LISTENER_PORT);
                registry.bind(ClientListener.NAME, stub);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("Client initialized");
        }
        while (true) {
            //System.out.println("Listening to clients");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.print(e.getMessage());
            }

        }
    }

    public ClientListener getClientListener() {
        return clientListener;
    }

    public DataProvider getDataProvider() {
        return dataProvider;
    }
    
    public boolean setOnline(int userID) {
        return usersOnline.add(userID);
    }

    public boolean setOffline(int userID) {
        return usersOnline.remove((Integer)userID);
    }

    private ClientListener clientListener = new SimpleClientListener(this);
    private DataProvider dataProvider = new DBProxy();
    private List<Integer> usersOnline = new ArrayList<Integer>();
}
