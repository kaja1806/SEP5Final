package Server;

import Interface.IServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartServer {
    public static void main(String[] args) {
        try {
            IServer s = new Server();
            Registry reg = LocateRegistry.createRegistry(1099);
            reg.bind("Budget", s);
            System.out.println("Server Started");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
