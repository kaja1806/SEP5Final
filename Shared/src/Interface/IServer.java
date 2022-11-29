package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServer extends Remote {
    void message(String msg) throws RemoteException;
}
