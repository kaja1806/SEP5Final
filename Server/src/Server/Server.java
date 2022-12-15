package Server;

import Interface.IServer;
import Interface.IServerClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements IServer {
    public Server() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void message(String msg) {
        System.out.println(msg);
    }

    @Override
    public IServerClient getClient() throws RemoteException {
        return new ServerClientHandler();
    }

}
