package BudgetClient;

import Interface.IServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class BudgetClient implements IBudgetClient {
    private final IServer sInterfaceM;
    public BudgetClient() throws RemoteException, NotBoundException, MalformedURLException {
        sInterfaceM = (IServer) Naming.lookup("rmi://localhost:1099/Budget");
        sInterfaceM.message("Budget Client Connected");
    }

}
