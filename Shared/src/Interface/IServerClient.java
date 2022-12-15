package Interface;

import Model.UserModel;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServerClient extends Remote, Serializable {

    String createUser(UserModel userModel) throws RemoteException;

    int validateUser(String name, String pass) throws RemoteException;
}
