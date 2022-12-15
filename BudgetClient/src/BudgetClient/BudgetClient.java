package BudgetClient;

import Interface.IServer;
import Model.UserModel;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class BudgetClient implements IBudgetClient {
    private final IServer server;

    public BudgetClient() throws RemoteException, NotBoundException, MalformedURLException {
        server = (IServer) Naming.lookup("rmi://localhost:1099/Budget");
        server.message("Budget Client Connected");
    }

    @Override
    public String createUser(UserModel userModel) {
        try {
            return server.getClient().createUser(userModel);
        } catch (RemoteException e) {
            return "Error";
        }
    }

    @Override
    public int validateUser(String name, String pass) {
        try {
            return server.getClient().validateUser(name, pass);
        } catch (RemoteException e) {
            return 0;
        }
    }
}
