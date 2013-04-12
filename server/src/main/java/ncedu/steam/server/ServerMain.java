package ncedu.steam.server;

import ncedu.steam.server.clientInteraction.SimpleClientListener;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * ServerMain
 * User: aielemental
 * Date: 20.03.13
 * Time: 12:44
 */
//todo add description
public class ServerMain {
    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
