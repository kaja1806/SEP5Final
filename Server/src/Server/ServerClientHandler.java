package Server;

import Interface.IServerClient;
import Model.ClientHandler;
import Model.IClientHandler;
import Model.UserModel;

import java.rmi.RemoteException;

public class ServerClientHandler implements IServerClient {

    private final IClientHandler clientHandler;

    public ServerClientHandler() throws RemoteException {
        clientHandler = new ClientHandler();
    }

    public String createUser(UserModel userModel) {
        return clientHandler.createUser(userModel);
    }
    public int validateUser(String name, String pass) {return clientHandler.validateUser(name, pass); }
}
