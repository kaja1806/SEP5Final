package Interface;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote, Serializable {
    void message(String msg) throws RemoteException;

    IServerClient getClient() throws RemoteException;
}
