package Server;

import Interface.*;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;

public class Server implements IServer {
    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }

}
